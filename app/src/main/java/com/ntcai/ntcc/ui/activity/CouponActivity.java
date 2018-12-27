package com.ntcai.ntcc.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.flyco.tablayout.SlidingTabLayout;
import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 优惠券列表
 */
public class CouponActivity extends BaseActivity {
    @BindView(R.id.title)
    TitleBar title;
    @BindView(R.id.tab)
    SlidingTabLayout tab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        ButterKnife.bind(this);
        initToolBar(title, "优惠券", "");
    }
}
