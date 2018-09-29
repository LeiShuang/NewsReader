package com.example.zfsoft.rxjavademo.base;

import android.support.v7.app.AppCompatDelegate;
import android.view.ViewGroup;

import com.example.zfsoft.rxjavademo.app.App;
import com.example.zfsoft.rxjavademo.di.component.ActivityComponent;
import com.example.zfsoft.rxjavademo.di.component.DaggerActivityComponent;
import com.example.zfsoft.rxjavademo.di.module.ActivityModule;
import com.example.zfsoft.rxjavademo.utils.SnackbarUtil;

import javax.inject.Inject;


/**
 * 创建日期：2018/7/4 on 15:12
 * 描述:mvp模式下的基类activity
 * 作者:Ls
 */
public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView {
    @Inject
    protected T presenter;

    protected ActivityComponent getActivityComponent(){
       return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();


    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        //注入初始化操作
        initInject();
        if (presenter != null){
            presenter.attachView(this);
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
    protected void initEventAndData() {

    }

    @Override
    public void showErrorMessage(String msg) {
        SnackbarUtil.show(((ViewGroup)findViewById(android.R.id.content)).getChildAt(0),msg);
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

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }
}
