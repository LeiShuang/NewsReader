package com.example.zfsoft.rxjavademo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.example.zfsoft.rxjavademo.app.App;
import com.example.zfsoft.rxjavademo.di.component.DaggerFragmentComponent;
import com.example.zfsoft.rxjavademo.di.component.FragmentComponent;
import com.example.zfsoft.rxjavademo.di.module.FragmentModule;
import com.example.zfsoft.rxjavademo.utils.SnackbarUtil;

import javax.inject.Inject;

/**
 * 创建日期：2018/7/4 on 17:58
 * 描述:Fragment基类
 * 作者:Ls
 */
public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView{
    @Inject
    protected T  presenter;

    protected FragmentComponent getFragmentComponent(){
      return DaggerFragmentComponent.builder()
              .appComponent(App.getAppComponent())
              .fragmentModule(getFragmentMoudle())
              .build();
    }

    protected FragmentModule getFragmentMoudle(){
        return new FragmentModule(this);
    }

    @Override
    public void showErrorMessage(String msg) {
        SnackbarUtil.show(((ViewGroup)getActivity().findViewById(android.R.id.content)).getChildAt(0),msg);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        presenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (presenter != null){
            presenter.detachView();
        }
        super.onDestroyView();
    }

    protected abstract void initInject();

    @Override
    public void useNightMode(boolean isNight) {

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
    protected void initEventAndData() {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
