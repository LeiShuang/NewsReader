package com.example.zfsoft.rxjavademo.di.component;

import com.example.zfsoft.rxjavademo.app.App;
import com.example.zfsoft.rxjavademo.di.module.AppModule;
import com.example.zfsoft.rxjavademo.di.module.HttpModule;
import com.example.zfsoft.rxjavademo.module.http.RetrofitHelper;
import com.example.zfsoft.rxjavademo.module.prefes.DataManager;
import com.example.zfsoft.rxjavademo.module.prefes.ImplPreferenceHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 创建日期：2018/7/3 on 15:59
 * 描述:提供注入的方法，指明要注入的moudle
 * 作者:Ls
 */
@Singleton
@Component(modules = {AppModule.class,HttpModule.class})
public interface AppComponent {

    App getContext();//提供App的Context;

    DataManager getDataManager();//数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    ImplPreferenceHelper preferencesHelper();//提供sp帮助类
}
