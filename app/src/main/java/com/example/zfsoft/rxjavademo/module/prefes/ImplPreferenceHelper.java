package com.example.zfsoft.rxjavademo.module.prefes;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.zfsoft.rxjavademo.app.App;
import com.example.zfsoft.rxjavademo.app.Constants;

import javax.inject.Inject;

/**
 * 创建日期：2018/7/17 on 16:47
 * 描述:
 * 作者:Ls
 */
public class ImplPreferenceHelper implements PreferencesHelper {
    private  SharedPreferences mSprefs;
    private static final String SHAREDPREFERENCES_NAME = "my_sp";
    private static final int DEFAULT_CURRENT_ITEM = Constants.TYPE_JOKER;
    @Inject
    public ImplPreferenceHelper(){
        mSprefs = App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public int getCurrentItem() {
        return mSprefs.getInt(Constants.SP_CURRENT_ITEM,DEFAULT_CURRENT_ITEM);
    }

    @Override
    public void setCurrentItem(int item) {
        mSprefs.edit().putInt(Constants.SP_CURRENT_ITEM, item).apply();
    }
}
