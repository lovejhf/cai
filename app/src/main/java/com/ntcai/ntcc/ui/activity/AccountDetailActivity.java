package com.ntcai.ntcc.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountDetailActivity extends BaseActivity {

    @BindView(R.id.title)
    TitleBar title;
    @BindView(R.id.account_detail_list)
    RecyclerView accountDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);
        ButterKnife.bind(this);
        initToolBar(title,"账户明细","");
        accountDetailList.setLayoutManager(new LinearLayoutManager(this));
    }
}
