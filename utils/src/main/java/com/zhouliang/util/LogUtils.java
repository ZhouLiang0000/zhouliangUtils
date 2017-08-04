package com.zhouliang.util;

import android.util.Log;

/**
 * Created by zhouliang on 2017/8/3.
 */

public class LogUtils {
    private static boolean isDebug = true;

    public LogUtils() {
    }

    public static boolean getDebugFlag() {
        return isDebug;
    }

    public static void setDebugFlag(boolean debug) {
        isDebug = debug;
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }

    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }

    }

    public static void e(String tag, String msg, Exception e) {
        if (isDebug) {
            Log.e(tag, msg, e);
        }

    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }

    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(tag, msg);
        }

    }

    public static void w(String tag, String msg, Exception e) {
        if (isDebug) {
            Log.w(tag, msg, e);
        }

    }

    public static void w(String tag, String msg, Throwable tr) {
        if (isDebug) {
            Log.w(tag, msg, tr);
        }

    }

    public static void w(String tag, Exception e) {
        if (isDebug) {
            Log.w(tag, e);
        }

    }

    public static void v(String tag, String msg) {
        if (isDebug) {
            Log.v(tag, msg);
        }

    }
}
