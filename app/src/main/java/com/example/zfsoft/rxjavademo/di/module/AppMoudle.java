package com.example.zfsoft.rxjavademo.di.module;

import android.app.Application;
import com.example.zfsoft.rxjavademo.app.App;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * 创建日期：2018/7/3 on 16:14
 * 描述:提供注入的实例
 * 作者:Ls
 */
@Module
public class AppMoudle {
    private final App mApplication;

    public AppMoudle(App application) {
        this.mApplication = application;
    }
    @Provides
    @Singleton
    App provideApplicationContext(){
        return mApplication;
    }
}
