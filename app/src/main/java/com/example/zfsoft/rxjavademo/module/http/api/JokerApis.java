package com.example.zfsoft.rxjavademo.module.http.api;

import com.example.zfsoft.rxjavademo.module.bean.TextNewsBean;
import com.example.zfsoft.rxjavademo.module.http.JokerHttpResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 创建日期：2018/7/13 on 13:55
 * 描述:
 * 作者:Ls
 */
public interface JokerApis {

    String HOST = "http://route.showapi.com/";

    /**
     * 笑话大全列表
     * */
    @GET("341-3")
    Flowable<JokerHttpResponse<List<TextNewsBean.ContentlistBean>>> getjokerStores(@Query("showapi_appid")String appid, @Query("showapi_sign")String sign,
                                                                                   @Query("page")String page, @Query("maxResult")String maxResult);


}
