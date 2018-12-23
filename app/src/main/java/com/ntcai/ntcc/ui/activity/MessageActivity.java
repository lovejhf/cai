package com.ntcai.ntcc.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;

import butterknife.BindView;
import butterknife.ButterKnife;

//消息列表
public class MessageActivity extends BaseActivity {

    @BindView(R.id.message_list)
    RecyclerView messageList;
    @BindView(R.id.title)
    TitleBar title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        initToolBar(title,"消息列表","");
    }
}
