package com.zhouliang.util.mvp;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by zhouliang on 2017/10/24.
 */

public abstract class MVPPresent<V extends BaseView, M extends BaseModel> implements IMVPPresent<V, M> {
    private Reference<V> mViewRef;

    private M model;

    public MVPPresent(M model) {
        this.model = model;
    }

    /**
     * 初始化Presenter
     */
    public void attachView(V view) {
        mViewRef = new WeakReference<>(view);
    }

    /**
     * 销毁Presenter持有的View引用
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public V getView() {
        if (mViewRef == null) return null;
        return mViewRef.get();
    }

    public final M getModel() {
        return model;
    }
}
