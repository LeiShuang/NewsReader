package com.example.zfsoft.rxjavademo.module.http;


import com.example.zfsoft.rxjavademo.module.bean.TextNewsBean;

import java.util.List;

import io.reactivex.Flowable;

/**
 * 创建日期：2018/7/27 on 11:41
 * 描述:
 * 作者:Ls
 */
public class ImplHttpHelper implements HttpHelper{
    public ImplHttpHelper() {

    }

    @Override
    public Flowable<JokerHttpResponse<List<TextNewsBean.ContentlistBean>>> getNewsList(String appId, String sign, String page, String maxResult) {
        return null;
    }
}
