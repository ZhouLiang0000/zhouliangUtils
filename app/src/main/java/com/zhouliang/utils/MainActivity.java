package com.zhouliang.utils;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.zhouliang.util.AppUtils;
import com.zhouliang.util.NetUtils;
import com.zhouliang.util.PermissionUtils;
import com.zhouliang.util.ToastUtils;
import com.zhouliang.utils.base.UtilsActivity;
import com.zhouliang.utils.domain.MessageEvent;
import com.zhouliang.utils.domain.User;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends UtilsActivity implements EasyPermissions.PermissionCallbacks {
    private static String TAG = MainActivity.class.getSimpleName();
    private static String packageName = "com.ai.kara.aitribe";
    private static String permission = Manifest.permission.READ_PHONE_STATE;
    private static final int MAIN_PERMISSION_CODE = 1;
    @BindView(R.id.eventbus_bt)
    Button eventbusBt;
    @BindView(R.id.utils_bt)
    Button utilsBt;
    @BindView(R.id.dao_bt)
    Button daoBt;
    @BindView(R.id.memory_leakage)
    Button memoryLeakageBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(MainActivity.this);
    }

    private void skipActivityMethod() {
        User user = new User();
        user.setUserName("周亮");
        user.setUserGender("男");
        EventBus.getDefault().postSticky(user);
        Intent mIntent = new Intent(MainActivity.this, EventBusActivity.class);
        startActivityForResult(mIntent, 100);
    }

    private void dealUtils() {
        if (NetUtils.isConnected(MainActivity.this)) {
            if (PermissionUtils.checkPermission(MainActivity.this, permission)) {
                dealMessage();
            } else {
                EasyPermissions.requestPermissions(this, "需要获取手机状态的权限", MAIN_PERMISSION_CODE, Manifest.permission.READ_PHONE_STATE);
            }
        } else {
            ToastUtils.getIntance().showToast(MainActivity.this, AppUtils.getVersionName(MainActivity.this), false);
        }
    }

    private void dealMessage() {
        if (AppUtils.isPackageExist(packageName, MainActivity.this)) {
            AppUtils.uninstallApk(MainActivity.this, packageName);
        } else {
            ToastUtils.getIntance().showToast(MainActivity.this, AppUtils.getAppName(MainActivity.this), true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this, getString(R.string.permissions_hint_title))
                    .setTitle(getString(R.string.permissions_hint_message))
                    .setPositiveButton(getString(R.string.permissions_hint_right_button))
                    .setNegativeButton(getString(R.string.permissions_hint_lift_button), null)
                    .setRequestCode(MAIN_PERMISSION_CODE)
                    .build()
                    .show();
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        dealMessage();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 200) {

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onMessageStickyEvent(MessageEvent event) {
        eventbusBt.setText(event.message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @OnClick({R.id.eventbus_bt, R.id.utils_bt, R.id.dao_bt,R.id.memory_leakage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.eventbus_bt:
                skipActivityMethod();
                break;
            case R.id.utils_bt:
                dealUtils();
                break;
            case R.id.dao_bt:
                DaoActivity.skipToDaoActivity(MainActivity.this);
                break;
            case R.id.memory_leakage:
                break;
        }
    }

}
