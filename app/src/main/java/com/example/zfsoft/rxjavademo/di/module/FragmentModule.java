package com.example.zfsoft.rxjavademo.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.zfsoft.rxjavademo.di.scop.FragmentScoped;

import dagger.Module;
import dagger.Provides;

/**
 * 创建日期：2018/7/4 on 20:00
 * 描述:
 * 作者:Ls
 */
@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }
    @Provides
    @FragmentScoped
    public Activity provideActivity(){
        return  mFragment.getActivity();
    }
}
