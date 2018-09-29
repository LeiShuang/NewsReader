package com.example.zfsoft.rxjavademo.ui.main.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.zfsoft.rxjavademo.R;
import com.example.zfsoft.rxjavademo.app.Constants;
import com.example.zfsoft.rxjavademo.base.BaseActivity;
import com.example.zfsoft.rxjavademo.base.contract.main.MainContract;
import com.example.zfsoft.rxjavademo.presenter.main.MainPresenter;
import com.example.zfsoft.rxjavademo.ui.joker.fragment.JokerMainFragment;
import com.example.zfsoft.rxjavademo.ui.news.NewsFragment;
import com.example.zfsoft.rxjavademo.utils.ToastUtil;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;
    @BindView(R.id.navigation)
    NavigationView mNavigation;
    @BindView(R.id.draw_layout)
    DrawerLayout mDrawLayout;
    private int hideFragment = Constants.TYPE_JOKER;
    private int showFragment = Constants.TYPE_JOKER;
    MenuItem mLastMenuItem;
    MenuItem mSearchMenuItem;
    ActionBarDrawerToggle mActionBarDrawerToggle;
    JokerMainFragment mJokerFragment;
    NewsFragment mNewsFragment;
    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }


    /**
     * @param savedInstanceState
     * @desc recreate()之后需要重新处理夜间模式
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            presenter.setNightModeState(false);
        } else {
            showFragment = presenter.getCurrentItem();
            hideFragment = Constants.TYPE_JOKER;
            showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
            mNavigation.getMenu().findItem(R.id.drawer_joker).setChecked(false);
            mToolBar.setTitle(mNavigation.getMenu().findItem(getCurrentItem(showFragment)).getTitle().toString());
            hideFragment = showFragment;
        }
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolBar,"笑话大全");
        mJokerFragment = new JokerMainFragment();
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawLayout,mToolBar,R.string.drawr_toggle_open,R.string.drawr_toggle_close);
        mActionBarDrawerToggle.syncState();
        mDrawLayout.addDrawerListener(mActionBarDrawerToggle);
        mLastMenuItem = mNavigation.getMenu().findItem(R.id.drawer_joker);
        loadMultipleRootFragment(R.id.left_frame_layout,0,mJokerFragment,mNewsFragment);
        mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.drawer_joker:
                        showFragment = Constants.TYPE_JOKER ;
                        mSearchMenuItem.setVisible(false);
                        break;
                   /* case R.id.drawer_news:
                        showFragment = Constants.TYPE_NEWS;
                        mSearchMenuItem.setVisible(false);
                        break;*/

                }
                    if (mLastMenuItem != null){
                        mLastMenuItem.setChecked(false);
                    }
                    mLastMenuItem = item;
                presenter.setCurrentItem(showFragment);
                item.setChecked(true);
                mToolBar.setTitle(item.getTitle());
                mDrawLayout.closeDrawers();
                showHideFragment(getTargetFragment(showFragment),getTargetFragment(hideFragment));
                hideFragment = showFragment;
                return true;
            }
        });
    }

    private int getCurrentItem(int item) {
        switch (item){
            case Constants.TYPE_JOKER:
                return R.id.drawer_joker;
           /* case Constants.TYPE_NEWS:
                return R.id.drawer_news;*/

        }
        //默认返回笑话大全的页面
        return R.id.drawer_joker;
    }

    private SupportFragment getTargetFragment(int item) {
        switch (item){
            case Constants.TYPE_JOKER:
                return mJokerFragment;

            case Constants.TYPE_NEWS:
                return mNewsFragment;
        }
        return mJokerFragment;
    }

    @Override
    public void showUpdateDialog(String versionContent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("检测到新版本");
        builder.setMessage(versionContent);
        builder.setNegativeButton("取消",null);
        builder.setPositiveButton("更新",new  AlertDialog.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                checkPermissions();
            }
        });
        builder.show();
    }

    private void checkPermissions() {
        presenter.checkPermissions(new RxPermissions(this));
    }

    @Override
    public void startDownLoadService() {
        ToastUtil.show("开始下载");
    }
}
