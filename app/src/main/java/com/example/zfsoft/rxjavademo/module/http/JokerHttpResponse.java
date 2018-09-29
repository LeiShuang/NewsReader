package com.example.zfsoft.rxjavademo.module.http;

/**
 * 创建日期：2018/7/11 on 14:53
 * 描述:笑话大全请求返回数据类型
 * 作者:Ls
 */
public class JokerHttpResponse<T> {
        private String showapi_res_error;
        private int showapi_res_code;
        private T showapi_res_body;

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public T getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(T showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }
}
