package com.example.zfsoft.rxjavademo.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.example.zfsoft.rxjavademo.di.component.AppComponent;
import com.example.zfsoft.rxjavademo.di.component.DaggerAppComponent;
import com.example.zfsoft.rxjavademo.di.module.AppMoudle;

import java.util.HashSet;
import java.util.Set;

import io.realm.Realm;

/**
 * 创建日期：2018/7/3 on 14:44
 * 描述:
 * 作者:Ls
 */
public class App extends Application{
    private static App instance;
    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;
    private Set<Activity> allActivities;
    private static AppComponent mAppComponent;
    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO
        );


    }
    public static synchronized App getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //初始化屏幕宽高
        getScreenSize();

        //初始化数据库
        Realm.init(getApplicationContext());


    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    private void getScreenSize() {
        WindowManager windowManager = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if(SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }

    public  void addActivity(Activity activity){
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(activity);
    }

    public void removeActivity(Activity activity){
        if (allActivities != null){
            allActivities.remove(activity);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public static AppComponent getAppComponent(){
        if(mAppComponent == null){
           mAppComponent = DaggerAppComponent.builder()
                   .appMoudle(new AppMoudle(instance))
                   .build();
        }
        return  mAppComponent;
    }
}
