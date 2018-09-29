package com.example.zfsoft.rxjavademo.base.contract.main;

import com.example.zfsoft.rxjavademo.base.BasePresenter;
import com.example.zfsoft.rxjavademo.base.BaseView;
import com.example.zfsoft.rxjavademo.bean.WelcomeBean;

/**
 * 创建日期：2018/9/29 on 17:06
 * 描述:
 * 作者:Ls
 */
public interface WelcomeContract {
    interface View extends BaseView{
        void showContent(WelcomeBean info );

        void jumpToMain();
    }

    interface Presenter extends BasePresenter<View>{
        void getWelcomeData();
    }
}
