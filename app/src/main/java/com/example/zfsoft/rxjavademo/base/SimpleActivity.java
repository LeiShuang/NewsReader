package com.example.zfsoft.rxjavademo.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.SupportActivity;

import com.example.zfsoft.rxjavademo.app.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建日期：2018/7/4 on 15:20
 * 描述:无MVP的Activity基类
 * 作者:Ls
 */
public abstract class SimpleActivity  extends SupportActivity{
    private Activity mContext;
    private Unbinder mUnbinder;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayout());
        mUnbinder = ButterKnife.bind(this);
        mContext = this;
        onViewCreated();
        App.getInstance().addActivity(this);
        initEventAndData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
        mUnbinder.unbind();
    }

    protected void onViewCreated() {
    }

    protected abstract int getlayout();
    protected abstract void initEventAndData();
}
