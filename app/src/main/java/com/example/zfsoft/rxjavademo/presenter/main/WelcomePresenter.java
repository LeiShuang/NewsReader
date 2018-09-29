package com.example.zfsoft.rxjavademo.presenter.main;

import com.example.zfsoft.rxjavademo.base.RxPresenter;
import com.example.zfsoft.rxjavademo.base.contract.main.WelcomeContract;
import com.example.zfsoft.rxjavademo.module.prefes.DataManager;

import javax.inject.Inject;

/**
 * 创建日期：2018/9/29 on 17:13
 * 描述:欢迎页presenter
 * 作者:Ls
 */
public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter{
    private DataManager mDataManager;
    @Override
    public void getWelcomeData() {

    }

   @Inject
    public WelcomePresenter (DataManager dataManager){
        this.mDataManager = dataManager;
   }
}
