package com.zhouliang.util;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.PermissionChecker;

import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by zhouliang on 2017/8/7.
 */

public class PermissionUtils {
    public PermissionUtils() {
    }

    public static boolean isPermissionGranted(Context context, String permission) {
        boolean result = true;
        if(Build.VERSION.SDK_INT >= 23) {
            if(AppUtils.getSystemVersion(context) >= 23) {
                result = EasyPermissions.hasPermissions(context, new String[]{permission});
            } else {
                result = PermissionChecker.checkSelfPermission(context, permission) == 0;
            }
        }

        return result;
    }
}
