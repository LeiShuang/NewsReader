package com.example.zfsoft.rxjavademo.ui.joker.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import com.example.zfsoft.rxjavademo.R;
import com.example.zfsoft.rxjavademo.base.SimpleFragment;
import com.example.zfsoft.rxjavademo.ui.joker.adapter.JokerAdapter;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;


/**
 * 创建日期：2018/7/4 on 20:08
 * 描述:笑话大全外层Fragment
 * 作者:Ls
 */
public class JokerMainFragment extends SimpleFragment {
    @BindView(R.id.tab_joker)
    TabLayout mTabLayout;
    @BindView(R.id.vp_joker)
    ViewPager mViewPager;

    List<Fragment> mFragments = new ArrayList<>();
    String[] tabTitle = new String[]{"文字", "图文", "其他"};
    JokerAdapter mAdapter;




    @Override
    protected void initEventAndData() {
        mFragments.add(new TextJokerFragment());
        mFragments.add(new SecondFragment());
        mFragments.add(new ThirdFragment());
        mAdapter = new JokerAdapter(getChildFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);

        mTabLayout.addTab(mTabLayout.newTab().setText(tabTitle[0]));
        mTabLayout.addTab(mTabLayout.newTab().setText(tabTitle[1]));
        mTabLayout.addTab(mTabLayout.newTab().setText(tabTitle[2]));

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText(tabTitle[0]);
        mTabLayout.getTabAt(1).setText(tabTitle[1]);
        mTabLayout.getTabAt(2).setText(tabTitle[2]);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_joker;
    }

}
