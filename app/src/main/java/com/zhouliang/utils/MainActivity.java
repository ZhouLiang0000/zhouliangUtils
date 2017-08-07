package com.zhouliang.utils;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.zhouliang.util.AppUtils;
import com.zhouliang.util.NetUtils;
import com.zhouliang.util.PermissionUtils;
import com.zhouliang.util.ToastUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
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
        if (NetUtils.isConnected(MainActivity.this)) {
            if (PermissionUtils.checkPermission(MainActivity.this,permission)) {
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
//            LogUtils.i(TAG, "点击了测试按钮");
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
}
