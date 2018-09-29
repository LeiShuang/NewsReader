package com.example.zfsoft.rxjavademo.di.module;

import android.app.Activity;
import com.example.zfsoft.rxjavademo.di.scop.ActivityScope;
import com.example.zfsoft.rxjavademo.module.http.HttpHelper;
import com.example.zfsoft.rxjavademo.module.http.ImplHttpHelper;
import com.example.zfsoft.rxjavademo.module.http.RetrofitHelper;
import com.example.zfsoft.rxjavademo.module.http.api.JokerApis;
import com.example.zfsoft.rxjavademo.module.prefes.DataManager;
import com.example.zfsoft.rxjavademo.module.prefes.ImplPreferenceHelper;
import com.example.zfsoft.rxjavademo.module.prefes.PreferencesHelper;
import com.example.zfsoft.rxjavademo.presenter.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * 创建日期：2018/7/4 on 14:59
 * 描述:
 * 作者:Ls
 */
@Module
public class ActivityModule {
    private  Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

/*    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(DataManager dataManager){
        return new MainPresenter(dataManager);
    }*/
    @Provides
    @ActivityScope
    public Activity provideActivity(){
        return  mActivity;
    }
}
