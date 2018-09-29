package com.example.zfsoft.rxjavademo.base.contract.main;

import com.example.zfsoft.rxjavademo.base.BasePresenter;
import com.example.zfsoft.rxjavademo.base.BaseView;
import com.tbruyelle.rxpermissions2.RxPermissions;

/**
 * 创建日期：2018/7/5 on 17:48
 * 描述:
 * 作者:Ls
 */
public interface MainContract {
    interface View extends BaseView{
        void showUpdateDialog(String versionContent);

        void startDownLoadService();
    }

    interface Presenter extends BasePresenter<View>{
        void checkVersion(String  currentVersion);
        void checkPermissions(RxPermissions rxPermissions);
        void setNightModeState(boolean b);
        void setCurrentItem(int index);
        int getCurrentItem();
        void setVersionPoint(boolean b);
        boolean getVersionPoint();
    }
}
