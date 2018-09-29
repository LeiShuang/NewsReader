package com.example.zfsoft.rxjavademo.utils;


import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * SnackBar工具类
 */

public class SnackbarUtil {

    public static void show(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showShort(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }
}
