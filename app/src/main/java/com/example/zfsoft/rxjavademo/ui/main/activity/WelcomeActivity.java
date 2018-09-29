package com.example.zfsoft.rxjavademo.ui.main.activity;


import com.example.zfsoft.rxjavademo.base.BaseActivity;
import com.example.zfsoft.rxjavademo.base.contract.main.WelcomeContract;
import com.example.zfsoft.rxjavademo.bean.WelcomeBean;
import com.example.zfsoft.rxjavademo.presenter.main.WelcomePresenter;

/**
 * 创建日期：2018/9/29 on 17:01
 * 描述:欢迎页activity
 * 作者:Ls
 */
public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {
    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    public void showContent(WelcomeBean info) {

    }

    @Override
    public void jumpToMain() {

    }
}
