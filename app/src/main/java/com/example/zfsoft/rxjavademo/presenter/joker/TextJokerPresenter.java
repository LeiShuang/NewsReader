package com.example.zfsoft.rxjavademo.presenter.joker;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.example.zfsoft.rxjavademo.app.Constants;
import com.example.zfsoft.rxjavademo.base.RxPresenter;
import com.example.zfsoft.rxjavademo.base.contract.joker.TextJokerContract;
import com.example.zfsoft.rxjavademo.module.bean.TextNewsBean;
import com.example.zfsoft.rxjavademo.module.http.JokerHttpResponse;
import com.example.zfsoft.rxjavademo.module.prefes.DataManager;
import com.example.zfsoft.rxjavademo.utils.RxUtil;
import com.example.zfsoft.rxjavademo.widget.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

import dagger.Provides;
import io.reactivex.Flowable;

/**
 * 创建日期：2018/7/11 on 9:48
 * 描述:
 * 作者:Ls
 */
public class TextJokerPresenter  extends RxPresenter<TextJokerContract.View> implements TextJokerContract.Presenter{
    private DataManager mDataManager;
    private int currentPage = 1;
    @Inject
    public TextJokerPresenter(DataManager manager) {
        mDataManager = manager;
    }

    @Override
    public void getData() {
        currentPage = 1;
        CommonSubscriber<List<TextNewsBean.ContentlistBean>> subscriber = mDataManager.getNewsList(Constants.JOKER_APP_ID, Constants.JOKER_APP_SIGN, String.valueOf(currentPage), Constants.REQUEST_MAXRESULT)
                .compose(RxUtil.<JokerHttpResponse<List<TextNewsBean.ContentlistBean>>> rxSchedulerHelper())
                .compose(RxUtil.<List<TextNewsBean.ContentlistBean>> handleResult())
                .subscribeWith(new CommonSubscriber<List<TextNewsBean.ContentlistBean>>(mView) {
                    @Override
                    public void onNext(List<TextNewsBean.ContentlistBean> contentlistBeans) {
                            mView.showContent(contentlistBeans);
                    }
                });
        addSubScribe(subscriber);
    }
    //加载更多数据
    @Override
    public void getMoreData() {
        Flowable<JokerHttpResponse<List<TextNewsBean.ContentlistBean>>> observable;
        observable = mDataManager.getNewsList(Constants.JOKER_APP_ID,Constants.JOKER_APP_SIGN,String.valueOf(++currentPage),Constants.REQUEST_MAXRESULT);

        addSubScribe(observable
        .compose(RxUtil.<JokerHttpResponse<List<TextNewsBean.ContentlistBean>>>rxSchedulerHelper())
        .compose(RxUtil.<List<TextNewsBean.ContentlistBean>>handleResult())
        .subscribeWith(new CommonSubscriber<List<TextNewsBean.ContentlistBean>>(mView,"没有更多数据了o(╯□╰)o"){

            @Override
            public void onNext(List<TextNewsBean.ContentlistBean> contentlistBeans) {
                mView.showMoreContent(contentlistBeans);
            }
        }));
    }


    @Override
    public void attachview(TextJokerContract.View view) {
        registerEvent();
    }

    private void registerEvent() {
    }

    @Override
    public void detachView() {

    }
}
