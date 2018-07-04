package com.example.zfsoft.rxjavademo.base;

import android.app.Activity;

import com.example.zfsoft.rxjavademo.app.App;
import com.example.zfsoft.rxjavademo.di.component.ActivityComponent;
import com.example.zfsoft.rxjavademo.di.component.DaggerActivityComponent;
import com.example.zfsoft.rxjavademo.di.module.AcitivityMoudle;

import javax.inject.Inject;

/**
 * 创建日期：2018/7/4 on 15:12
 * 描述:
 * 作者:Ls
 */
public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView {
    @Inject
    protected  T  presenter;

    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .acitivityMoudle(getActivityMoudle())
                .build();
    }

    protected AcitivityMoudle getActivityMoudle() {
        return new AcitivityMoudle(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        //注入初始化操作
        initInject();
        if (presenter != null){
            presenter.attachview(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (presenter != null){
            presenter.detachView();
        }
        super.onDestroy();

    }

    

    protected abstract void initInject();

    @Override
    protected int getlayout() {
        return 0;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showErrorMessage(String msg) {

    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }


}
