package com.example.zfsoft.rxjavademo.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 创建日期：2018/7/11 on 10:46
 * 描述:基于Rx的presenter封装，控制订阅的生命周期
 * 作者:Ls
 */
public class RxPresenter<T extends BaseView > implements BasePresenter<T>{
    protected T mView;
    protected CompositeDisposable mCompositeDisposable;




    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubScribe();
    }

    protected void unSubScribe() {
       if (mCompositeDisposable != null){
           mCompositeDisposable.clear();
       }
    }

    protected void addSubScribe(Disposable subscription){
        if (mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }

        mCompositeDisposable.add(subscription);
    }

    protected <U> void addRxBusSubscribe(Class<U> eventType, Consumer<U> act) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(RxBus.getDefault().toDefaultFlowable(eventType, act));
    }

    protected void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
