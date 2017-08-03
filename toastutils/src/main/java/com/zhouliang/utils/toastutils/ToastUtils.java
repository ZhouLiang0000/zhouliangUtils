package com.zhouliang.utils.toastutils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.zhouliang.utils.logutils.LogUtils;

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
    public void showToast(Context mContext,CharSequence msg,int duration){
        if(msg == null || msg.equals("")) {
            LogUtils.i(TAG, "Toast的提示信息不能为空，弹出Toast失败");
        }

        if(this.mToast == null) {
            this.mToast = Toast.makeText(mContext, msg, duration);
        } else {
            this.mToast.setText(msg);
        }

        this.mToast.show();
    }
    public void showCustomToast(Context mContext,CharSequence msg,int duration){
        if(msg == null || msg.equals("")) {
            LogUtils.i(TAG, "Toast的提示信息不能为空，弹出Toast失败");
        }

        if(this.mToast == null) {
            this.mToast = Toast.makeText(mContext, msg, duration);
        } else {
            this.mToast.setText(msg);
        }
        this.mToast.setGravity(Gravity.CENTER,0,0);
        this.mToast.show();
    }
    public void showToast(Context context, CharSequence msg,boolean isCustom) {
        if(isCustom){
            this.showCustomToast(context, msg, 0);
        }else{
            this.showToast(context, msg, 0);
        }
    }

    public void showToast(Context context, int stringResID,boolean isCustom) {
        if(isCustom){
            this.showCustomToast(context, context.getString(stringResID), 0);
        }else{
            this.showToast(context, context.getString(stringResID), 0);
        }
    }

    public void showToast(Context context, int stringResID, int duration,boolean isCustom) {
        if(isCustom){
            this.showCustomToast(context, context.getString(stringResID), duration);
        }else{
            this.showToast(context, context.getString(stringResID), duration);
        }
    }

    public void dismiss() {
        if(this.mToast != null) {
            this.mToast.cancel();
        }

    }
}
