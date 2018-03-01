package com.zhouliang.util.base.activity;

import android.os.Bundle;

import com.zhouliang.util.base.activity.AIBaseActivity;
import com.zhouliang.util.mvp.IMVPPresent;

/**
 * Created by zhouliang on 2017/10/24.
 */

public abstract class MVPActivity<P extends IMVPPresent> extends AIBaseActivity{
    public P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMVP();
    }

    @SuppressWarnings("unchecked")
    public final void initMVP() {
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
