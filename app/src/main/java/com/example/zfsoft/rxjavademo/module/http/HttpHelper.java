package com.example.zfsoft.rxjavademo.module.http;


import com.example.zfsoft.rxjavademo.module.bean.TextNewsBean;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * 创建日期：2018/7/13 on 11:21
 * 描述:  返回一个 已定义笑话数据类型的Flowable
 * 作者:Ls
 */
public interface HttpHelper {

    Flowable<JokerHttpResponse<List<TextNewsBean.ContentlistBean>>> getNewsList(String appId,String sign,String page,String maxResult);
}
