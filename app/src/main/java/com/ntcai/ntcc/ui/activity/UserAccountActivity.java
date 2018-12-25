package com.ntcai.ntcc.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAccountActivity extends BaseActivity {
    @BindView(R.id.title)
    TitleBar title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        ButterKnife.bind(this);
        initToolBar(title,"我的账户","账户明细");
    }
}
