package com.ntcai.ntcc.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.ui.fragment.OrderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineOrderActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.title)
    TitleBar title;
    @BindView(R.id.tab)
    SlidingTabLayout tab;
    private String[] tabMenus = {"全部","待付款","待发货","已发货","已完成"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_order);
        ButterKnife.bind(this);
        initToolBar(title,"我的订单","");
        title.setRightIcon(R.mipmap.ic_buy_guide);
        OrderViewPagerAdapter messageAdapter = new OrderViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(messageAdapter);
        tab.setViewPager(viewPager);

    }

    public class OrderViewPagerAdapter extends FragmentPagerAdapter {


        public OrderViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabMenus[position];
        }
        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            OrderFragment orderFragment= (OrderFragment) object;
            Bundle bundle = new Bundle();
            bundle.putString("orderType",tabMenus[position]);
            orderFragment.setArguments(bundle);
            super.setPrimaryItem(container, position, object);
        }


        @Override
        public Fragment getItem(int position) {
            OrderFragment orderFragment = new OrderFragment();
            return orderFragment;
        }

        @Override
        public int getCount() {
            return tabMenus.length;
        }

    }
}
