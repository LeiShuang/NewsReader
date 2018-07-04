package com.example.zfsoft.rxjavademo.di.component;

import com.example.zfsoft.rxjavademo.app.App;
import com.example.zfsoft.rxjavademo.di.module.AppMoudle;
import com.example.zfsoft.rxjavademo.di.module.HttpMoudle;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 创建日期：2018/7/3 on 15:59
 * 描述:提供注入的方法，指明要注入的moudle
 * 作者:Ls
 */
@Singleton
@Component(modules = {AppMoudle.class,HttpMoudle.class})
public interface AppComponent {
    App getContext();//提供App的Context;

}
