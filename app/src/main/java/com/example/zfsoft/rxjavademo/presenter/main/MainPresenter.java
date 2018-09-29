package com.example.zfsoft.rxjavademo.presenter.main;

import com.example.zfsoft.rxjavademo.base.RxPresenter;
import com.example.zfsoft.rxjavademo.base.contract.main.MainContract;
import com.example.zfsoft.rxjavademo.di.scop.ActivityScope;
import com.example.zfsoft.rxjavademo.module.prefes.DataManager;
import com.example.zfsoft.rxjavademo.module.prefes.PreferencesHelper;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import dagger.Provides;

/**
 * 创建日期：2018/7/5 on 17:32
 * 描述:
 * 作者:Ls
 */
public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }



    @Override
    public void checkVersion(String currentVersion) {

    }

    @Override
    public void checkPermissions(RxPermissions rxPermissions) {

    }

    @Override
    public void setNightModeState(boolean b) {

    }

    @Override
    public void setCurrentItem(int index) {
        mDataManager.setCurrentItem(index);
    }

    @Override
    public int getCurrentItem() {
        return mDataManager.getCurrentItem();
    }

    @Override
    public void setVersionPoint(boolean b) {

    }

    @Override
    public boolean getVersionPoint() {
        return false;
    }
}
