package com.example.zfsoft.rxjavademo.base;

/**
 * 创建日期：2018/7/4 on 15:15
 * 描述:presenter的基类
 * 作者:Ls
 */
public interface BasePresenter<T extends BaseView> {
    void attachview(T view);
    void detachView();
}
