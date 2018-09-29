package com.example.zfsoft.rxjavademo.base.contract.joker;

import com.example.zfsoft.rxjavademo.base.BasePresenter;
import com.example.zfsoft.rxjavademo.base.BaseView;
import com.example.zfsoft.rxjavademo.module.bean.TextNewsBean;

import java.util.List;

/**
 * 创建日期：2018/7/11 on 10:11
 * 描述:
 * 作者:Ls
 */
public interface TextJokerContract {
    interface View extends BaseView{
        void showContent(List<TextNewsBean.ContentlistBean> info);
        void showMoreContent(List<TextNewsBean.ContentlistBean> info);
    }

    interface Presenter extends BasePresenter<View>{
        void getData();

        void getMoreData();
    }
}
