package com.zhouliang.util.mvp;

/**
 * Created by zhouliang on 2017/10/24.
 */

public interface IMVPPresent<V extends BaseView, M extends BaseModel> {
    /**
     * 初始化Presenter
     */
    void attachView(V view);

    /**
     * 销毁Presenter持有的View引用
     */
    void detachView();

    V getView();

    M getModel();
}
