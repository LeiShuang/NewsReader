package com.example.zfsoft.rxjavademo.module.prefes;

import com.example.zfsoft.rxjavademo.module.bean.TextNewsBean;
import com.example.zfsoft.rxjavademo.module.http.HttpHelper;
import com.example.zfsoft.rxjavademo.module.http.JokerHttpResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * 创建日期：2018/7/13 on 16:56
 * 描述:封装的一个数据工具类,可实现网络请求，本地存储，数据库增删改查
 * 作者:Ls
 */
public class DataManager implements HttpHelper,PreferencesHelper{

    HttpHelper mHttpHelper;

    PreferencesHelper mPreferencesHelper;

    public DataManager(HttpHelper httpHelper,PreferencesHelper helper) {
        mHttpHelper = httpHelper;
        mPreferencesHelper = helper;
    }

    @Override
    public Flowable<JokerHttpResponse<List<TextNewsBean.ContentlistBean>>> getNewsList(String appId, String sign, String page, String maxResult) {
        return mHttpHelper.getNewsList(appId,sign,page,maxResult);
    }

    @Override
    public int getCurrentItem() {
        return mPreferencesHelper.getCurrentItem();
    }

    @Override
    public void setCurrentItem(int item) {
        mPreferencesHelper.setCurrentItem(item);
    }
}
