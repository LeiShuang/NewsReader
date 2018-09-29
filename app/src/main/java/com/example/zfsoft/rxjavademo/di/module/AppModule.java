package com.example.zfsoft.rxjavademo.di.module;

import com.example.zfsoft.rxjavademo.app.App;
import com.example.zfsoft.rxjavademo.module.http.HttpHelper;
import com.example.zfsoft.rxjavademo.module.http.RetrofitHelper;
import com.example.zfsoft.rxjavademo.module.prefes.DataManager;
import com.example.zfsoft.rxjavademo.module.prefes.ImplPreferenceHelper;
import com.example.zfsoft.rxjavademo.module.prefes.PreferencesHelper;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * 创建日期：2018/7/3 on 16:14
 * 描述:提供注入的实例
 * 作者:Ls
 */
@Module
public class AppModule {
    private final App mApplication;

    public AppModule(App application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext(){
        return mApplication;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper){
        return  retrofitHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, PreferencesHelper helper){
        return  new DataManager(httpHelper,helper);
    }

 /* @Provides
    @Singleton
    ImplPreferenceHelper provideImplPreferenceHelper(){
        return new ImplPreferenceHelper();
    }*/
    @Provides
    @Singleton
    PreferencesHelper providePreferenceHelper(ImplPreferenceHelper implPreferenceHelper){
        return implPreferenceHelper;
    }
}
