package com.zhouliang.utils;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.widget.Button;

import com.zhouliang.util.AppUtils;
import com.zhouliang.util.LogUtils;
import com.zhouliang.util.NetUtils;
import com.zhouliang.util.PermissionUtils;
import com.zhouliang.util.ToastUtils;
import com.zhouliang.utils.base.UtilsActivity;
import com.zhouliang.utils.message.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends UtilsActivity implements EasyPermissions.PermissionCallbacks {
    private static String TAG = MainActivity.class.getSimpleName();
    private static String packageName = "com.ai.kara.aitribe";
    private static String permission = Manifest.permission.READ_PHONE_STATE;
    private static final int MAIN_PERMISSION_CODE = 1;
    @Bind(R.id.main_bt)
    Button mainBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_bt)
    public void onViewClicked() {
        dealMethod();
    }

    private void skipActivityMethod() {
        startActivity(new Intent(MainActivity.this, EventBusActivity.class));
    }

    private void dealMethod() {
//        dealUtils();
        skipActivityMethod();
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
        LogUtils.i(TAG, "点击了测试按钮");
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

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessagePostingEvent(MessageEvent event) {
        LogUtils.i(TAG,"onMessagePostingEvent ---- " + event.message+"==========="+Thread.currentThread());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageMainEvent(MessageEvent event) {
        LogUtils.i(TAG,"onMessageMainEvent ---- " + event.message+"==========="+Thread.currentThread());
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMessageBackgroundEvent(MessageEvent event) {
        LogUtils.i(TAG,"onMessageBackgroundEvent ---- " + event.message+"==========="+Thread.currentThread());
    }
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onMessageAsyncEvent(MessageEvent event) {
        LogUtils.i(TAG,"onMessageAsyncEvent ---- " + event.message+"==========="+Thread.currentThread());
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStart() {
        EventBus.getDefault().unregister(this);
        super.onStart();
    }
}
