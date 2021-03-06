package com.example.zfsoft.rxjavademo.base;

import android.view.View;
import android.view.ViewGroup;

import com.example.zfsoft.rxjavademo.R;
import com.example.zfsoft.rxjavademo.widget.ProgressImageView;

/**
 * 创建日期：2018/7/10 on 10:00
 * 描述:
 * 作者:Ls
 */
public abstract class RootFragment<T extends BasePresenter> extends BaseFragment<T>{
    private static final int STATE_MAIN = 0x00;
    private static final int STATE_LOADING = 0x01;
    private static final int STATE_ERROR = 0x02;

    private   ViewGroup viewMain;
    private   ViewGroup mParent;
    private int mErrorResource = R.layout.view_error;

    private int currentState = STATE_MAIN;
    private boolean isErrorViewAdded = false;
    private ProgressImageView ivLoading;
    private View viewError;
    private View viewLoading;
    @Override
    protected void initEventAndData() {
        if (getView() == null) {
            return;
        }
            viewMain = (ViewGroup) getView().findViewById(R.id.view_main);
            if (viewMain == null) {
                throw new IllegalStateException(
                        "The subclass of RootActivity must contain a View named 'view_main'.");
            }
            if (!(viewMain.getParent() instanceof ViewGroup)) {
                throw new IllegalStateException(
                        "view_main's ParentView should be a ViewGroup.");
            }

            mParent = (ViewGroup) viewMain.getParent();
            View.inflate(mContext, R.layout.view_progress, mParent);
            viewLoading = mParent.findViewById(R.id.view_loading);
            ivLoading = (ProgressImageView) viewLoading.findViewById(R.id.iv_progress);
            viewLoading.setVisibility(View.GONE);
            viewMain.setVisibility(View.VISIBLE);
        }


    @Override
    public void stateError() {
        if (currentState ==STATE_ERROR) {
            return;
        }
            if (!isErrorViewAdded){
                isErrorViewAdded = true;
                View.inflate(mContext,mErrorResource,mParent);
                viewError = mParent.findViewById(R.id.view_error);
                if (viewError == null){
                    throw new IllegalStateException(
                            "A View should be named 'view_error' in ErrorLayoutResource.");
                }
        }
        hideCurrentView();
        currentState = STATE_ERROR;
        viewError.setVisibility(View.VISIBLE);
    }


    @Override
    public void stateLoading() {
        if (currentState == STATE_LOADING) {
            return;
        }
            hideCurrentView();
            currentState = STATE_LOADING;
            viewLoading.setVisibility(View.VISIBLE);
            ivLoading.start();

    }

    private void hideCurrentView() {
        switch (currentState){
            case STATE_ERROR:
                viewError.setVisibility(View.GONE);
                break;
            case STATE_LOADING:
                ivLoading.stop();
                viewLoading.setVisibility(View.GONE);
                break;
            case STATE_MAIN:
                viewMain.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void stateMain() {
       if (currentState == STATE_MAIN){
           return;
       }
        hideCurrentView();
        currentState =STATE_MAIN;
        viewMain.setVisibility(View.VISIBLE);

    }
}
