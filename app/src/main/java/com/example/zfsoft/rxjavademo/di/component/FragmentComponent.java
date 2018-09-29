package com.example.zfsoft.rxjavademo.di.component;

import android.app.Activity;

import com.example.zfsoft.rxjavademo.di.module.FragmentModule;
import com.example.zfsoft.rxjavademo.di.scop.FragmentScoped;
import com.example.zfsoft.rxjavademo.ui.joker.fragment.TextJokerFragment;
import dagger.Component;

/**
 * 创建日期：2018/7/4 on 20:04
 * 描述:
 * 作者:Ls
 */

@FragmentScoped
@Component(modules = FragmentModule.class,dependencies = AppComponent.class)
public interface FragmentComponent {
    Activity getActivity();

    void inject(TextJokerFragment fragment);
}
