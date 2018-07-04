package com.example.zfsoft.rxjavademo.base;

/**
 * 创建日期：2018/7/4 on 15:10
 * 描述:view的基类
 * 作者:Ls
 */
public interface BaseView {
    void showErrorMessage(String msg);


    //----------state------------

    void stateError();

    void stateEmpty();

    void stateLoading();

    void stateMain();
}
