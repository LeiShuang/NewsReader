package com.example.zfsoft.rxjavademo.di.module;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 创建日期：2018/7/3 on 16:15
 * 描述:
 * 作者:Ls
 */
@Module
public class HttpMoudle {

    @Singleton
    @Provides
    Retrofit.Builder getRetrofitBuilder(){
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder getOkhttpClient(){
        return new  OkHttpClient.Builder();
    }
}
