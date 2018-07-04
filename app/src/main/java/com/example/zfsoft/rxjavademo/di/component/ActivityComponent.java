package com.example.zfsoft.rxjavademo.di.component;

import android.app.Activity;

import com.example.zfsoft.rxjavademo.di.module.AcitivityMoudle;
import com.example.zfsoft.rxjavademo.di.scop.ActivityScoped;
import com.example.zfsoft.rxjavademo.ui.main.MainActivity;
import dagger.Component;

/**
 * 创建日期：2018/7/4 on 14:58
 * 描述:
 * 作者:Ls
 */
@ActivityScoped
@Component(modules = AcitivityMoudle.class,dependencies = AppComponent.class)
public interface ActivityComponent {
    Activity getActivity();
    void inject(MainActivity mainActivity);

}
