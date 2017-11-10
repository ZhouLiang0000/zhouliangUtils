package com.zhouliang.util.mvp;

/**
 * Created by zhouliang on 2017/10/24.
 */

public interface BaseView {
    /**
     * 设置toolbar,也可以不实现这个方法
     */
    void initToolbar();

    /**
     * 显示加载进度条
     *
     * @param content 进度条内容，如果为null则显示默认内容
     */
    void showLoadingDialog(String content);

    /**
     * 隐藏加载进度条
     */
    void dismissLoadingDialog();

    /**
     * 界面结束
     */
    void finishActivity();
}
