package com.example.zfsoft.rxjavademo.module.http;

import com.example.zfsoft.rxjavademo.module.bean.TextNewsBean;
import com.example.zfsoft.rxjavademo.module.http.api.JokerApis;

import java.util.List;

import javax.inject.Inject;

import dagger.Provides;
import io.reactivex.Flowable;

/**
 * 创建日期：2018/7/13 on 11:21
 * 描述:
 * 作者:Ls
 */
public class RetrofitHelper implements HttpHelper {
    private JokerApis mJokerApis;

    @Inject
    public RetrofitHelper(JokerApis jokerApis) {
        mJokerApis = jokerApis;
    }



    @Override
    public Flowable<JokerHttpResponse<List<TextNewsBean.ContentlistBean>>> getNewsList(String appId, String sign, String page, String maxResult) {
        return mJokerApis.getjokerStores(appId,sign,page,maxResult);
    }
}
