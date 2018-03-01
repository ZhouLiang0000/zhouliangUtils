package com.zhouliang.util.base.fragment;

import android.os.Bundle;

import com.zhouliang.util.mvp.IMVPPresent;

/**
 * 作者：zhouliang
 * 时间：2018/3/1:10:44
 * 邮箱：18510971680@163.com
 * 说明：
 */
public abstract class MVPFragment<P extends IMVPPresent> extends AIBaseFragment{
    public P mPresenter;

    // 这个方法之前不能有同Activity交互的操作
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMVP();
    }

    /**
     * 初始化Presenter并传入View
     */
    @SuppressWarnings("unchecked")
    private void initMVP() {
        mPresenter = initPresenter();
        if (mPresenter != null) {
            // 这里一定是传入泛型
            mPresenter.attachView(this);
        }
    }

    /**
     * 实例化Presenter
     */
    public abstract P initPresenter();

    public P getPresenter() {
        return mPresenter;
    }

    // 布局被移除的时候调用,这个时候Activity的onDestroy已经开始被调用
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 在这里移除view的绑定
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

}
