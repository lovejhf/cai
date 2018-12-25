package com.ntcai.ntcc.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.ui.fragment.CardNoRechargeFragment;
import com.ntcai.ntcc.ui.fragment.OnLineRechargeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAccountActivity extends BaseActivity {
    @BindView(R.id.title)
    TitleBar title;
    @BindView(R.id.tab_layout)
    SegmentTabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private String[] mTitles = {"在线充值", "充值卡充值"};
    private List<Fragment> mFragments = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        ButterKnife.bind(this);
        initToolBar(title, "我的账户", "账户明细");
        tabLayout.setTabData(mTitles);
        mFragments.add(new OnLineRechargeFragment());
        mFragments.add(new CardNoRechargeFragment());
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tabLayout.setCurrentTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

}
