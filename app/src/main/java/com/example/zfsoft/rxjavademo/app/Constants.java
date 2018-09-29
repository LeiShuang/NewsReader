package com.example.zfsoft.rxjavademo.app;

import android.os.Environment;

import java.io.File;

/**
 * 创建日期：2018/7/5 on 13:58
 * 描述:
 * 作者:Ls
 */
public class Constants {
    public static final int TYPE_JOKER = 101;
    public static final int TYPE_NEWS = 102;
//    --------------Path---------------------
    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";
    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";

 //聊天的appid
    public static final String JOKER_APP_ID = "67919";
    public static final String JOKER_APP_SIGN = "5be359f525e441159779ad92f466f4a9";
    public static final String REQUEST_PAGE = "1";
    public static final String REQUEST_MAXRESULT = "20";

    //preference
    public static final String SP_CURRENT_ITEM = "current_item";
}
