package com.example.zfsoft.rxjavademo.di.component;

import android.app.Activity;

import com.example.zfsoft.rxjavademo.base.BaseActivity;
import com.example.zfsoft.rxjavademo.di.module.ActivityModule;
import com.example.zfsoft.rxjavademo.di.scop.ActivityScope;
import com.example.zfsoft.rxjavademo.ui.main.activity.MainActivity;
import dagger.Component;
import dagger.Provides;


/**
 * 创建日期：2018/7/4 on 14:58
 * 描述:
 * 作者:Ls
 *
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(MainActivity mainActivity);


}
