package com.example.zfsoft.rxjavademo.di.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建日期：2018/7/4 on 14:59
 * 描述:
 * 作者:Ls
 */
@Module
public class AcitivityMoudle {
    private Activity mActivity;

    public AcitivityMoudle(Activity activity) {
        mActivity = activity;
    }

    @Provides
    public Activity provideActivity(){
        return  mActivity;
    }
}
