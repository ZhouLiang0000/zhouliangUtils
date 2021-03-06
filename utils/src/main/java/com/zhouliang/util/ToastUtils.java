package com.zhouliang.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by zhouliang on 2017/8/3.
 */

public class ToastUtils {
    private static final String TAG = ToastUtils.class.getSimpleName();
    private Toast mToast;

    /**
     * 私有的构造函数
     */
    private ToastUtils() {

    }

    /**
     * 内部类实现单例模式
     * 延迟加载，减少内存开销
     */
    private static class ToastUtilsHolder {
        private static ToastUtils instance = new ToastUtils();
    }

    /**
     * 获取实例
     */
    public static ToastUtils getIntance() {
        return ToastUtilsHolder.instance;
    }

    public void showToast(Context mContext, CharSequence msg, int duration, boolean isCustom) {
        if (msg == null || msg.equals("")) {
            LogUtils.i(TAG, "Toast的提示信息不能为空，弹出Toast失败");
        }

        if (this.mToast == null) {
            this.mToast = Toast.makeText(mContext, msg, duration);
        } else {
            this.mToast.setText(msg);
        }
        if (isCustom) {
            this.mToast.setGravity(Gravity.CENTER, 0, 0);
        }else{
            this.mToast.setGravity(Gravity.BOTTOM,0,mContext.getResources().getDimensionPixelSize(R.dimen.toast_y_offset));
        }
        this.mToast.show();
    }

    public void showToast(Context context, CharSequence msg, boolean isCustom) {
        this.showToast(context, msg, 0, isCustom);
    }

    public void showToast(Context context, CharSequence msg) {
        this.showToast(context, msg, 0, false);
    }

    public void showToast(Context context, int stringResID, boolean isCustom) {
        this.showToast(context, context.getString(stringResID), 0, isCustom);
    }

    public void showToast(Context context, int stringResID) {
        this.showToast(context, context.getString(stringResID), 0, false);
    }

    public void showToast(Context context, int stringResID, int duration, boolean isCustom) {
        this.showToast(context, context.getString(stringResID), duration, isCustom);
    }

    public void showToast(Context context, int stringResID, int duration) {
        this.showToast(context, context.getString(stringResID), duration, false);
    }

    public void dismiss() {
        if (this.mToast != null) {
            this.mToast.cancel();
        }

    }
}
