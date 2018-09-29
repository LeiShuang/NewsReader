package com.example.zfsoft.rxjavademo.ui.joker.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.zfsoft.rxjavademo.R;
import com.example.zfsoft.rxjavademo.base.RootFragment;
import com.example.zfsoft.rxjavademo.base.contract.joker.TextJokerContract;
import com.example.zfsoft.rxjavademo.module.bean.TextNewsBean;
import com.example.zfsoft.rxjavademo.presenter.joker.TextJokerPresenter;
import com.example.zfsoft.rxjavademo.ui.joker.adapter.TextJokerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建日期：2018/7/9 on 15:55
 * 描述:
 * 作者:Ls
 */
public class TextJokerFragment extends RootFragment<TextJokerPresenter> implements TextJokerContract.View {
    List<TextNewsBean.ContentlistBean> lists;
    @BindView(R.id.view_main)
    RecyclerView mViewMain;
    @BindView(R.id.sw_refresh)
    SwipeRefreshLayout mSwRefresh;
    boolean isLoadingMore = false;
    private TextJokerAdapter mTextJokerAdapter;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        lists = new ArrayList<>();
        mTextJokerAdapter = new TextJokerAdapter(mContext, lists);
        mViewMain.setLayoutManager(new LinearLayoutManager(mContext));
        mViewMain.setAdapter(mTextJokerAdapter);
        mViewMain.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastItemPosition = ((LinearLayoutManager) mViewMain.getLayoutManager()).findLastVisibleItemPosition();
                int totalitemPosition = mViewMain.getLayoutManager().getItemCount();
                if (lastItemPosition >= totalitemPosition - 2 && dy > 0) {
                    if (!isLoadingMore) {
                        isLoadingMore = true;
                        presenter.getMoreData();
                    }
                }
            }
        });

        mSwRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getData();
            }
        });

        stateLoading();
        presenter.getData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_text_joker;
    }


    @Override
    public void showContent(List<TextNewsBean.ContentlistBean> info) {
        if (mSwRefresh.isRefreshing()) {
            mSwRefresh.setRefreshing(false);
        }
        stateMain();
        lists.clear();
        lists.addAll(info);
        mTextJokerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoreContent(List<TextNewsBean.ContentlistBean> info) {
        stateMain();
        lists.addAll(info);
        mTextJokerAdapter.notifyDataSetChanged();
        isLoadingMore = false;
    }

    @Override
    public void stateError() {
        super.stateError();
        if (mSwRefresh.isRefreshing()){
            mSwRefresh.setRefreshing(false);
        }
    }
}
