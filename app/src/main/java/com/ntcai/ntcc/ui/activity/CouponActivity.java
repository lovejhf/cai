package com.ntcai.ntcc.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.CallCountValue;
import com.ntcai.ntcc.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 优惠券列表
 */
public class CouponActivity extends BaseActivity  implements CallCountValue {
    @BindView(R.id.title)
    TitleBar title;
    @BindView(R.id.tab)
    SlidingTabLayout tab;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private String[] titles = {"可使用", "不可用"};
    private MyPagerAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        ButterKnife.bind(this);
        initToolBar(title, "优惠券", "");
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        tab.setViewPager(viewPager, titles);

    }

    @Override
    public void setCount(int count, String type) {
        if (type.equals("可使用")) {
            titles[0] = "可使用(" + count + ")";

        } else {
            titles[1] = "不可用(" + count + ")";

        }
        tab.setViewPager(viewPager, titles);

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            CouponFragment couponFragment = new CouponFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type",titles[position]);
            couponFragment.setArguments(bundle);
            return couponFragment;
        }
    }
}
