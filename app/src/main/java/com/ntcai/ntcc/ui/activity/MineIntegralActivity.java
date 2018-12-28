package com.ntcai.ntcc.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.UserIntegegralAdapter;
import com.ntcai.ntcc.bean.UserIntegegraVo;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MineIntegralActivity extends BaseActivity {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.title)
    TitleBar title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_integeral);
        ButterKnife.bind(this);
        initToolBar(title,"我的积分","");
        recycler.setLayoutManager(new LinearLayoutManager(this));
        List<UserIntegegraVo> userIntegegraVoList = new ArrayList<>();
        userIntegegraVoList.add(new UserIntegegraVo("系统赠送积分","2018.12.22",200));
        userIntegegraVoList.add(new UserIntegegraVo("系统赠送积分","2018.12.22",200));
        userIntegegraVoList.add(new UserIntegegraVo("系统赠送积分","2018.12.22",200));
        userIntegegraVoList.add(new UserIntegegraVo("系统赠送积分","2018.12.22",200));
        userIntegegraVoList.add(new UserIntegegraVo("系统赠送积分","2018.12.22",200));
        UserIntegegralAdapter userIntegegralAdapter = new UserIntegegralAdapter(R.layout.item_user_integera,userIntegegraVoList);
        recycler.setAdapter(userIntegegralAdapter);
        View header = LayoutInflater.from(this).inflate(R.layout.item_header,null);
        userIntegegralAdapter.addHeaderView(header);
    }
}
