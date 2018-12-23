package com.ntcai.ntcc.ui.activity;

import android.os.Bundle;

import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModifyPassWord extends BaseActivity {

    @BindView(R.id.title)
    TitleBar title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_pass_word);
        ButterKnife.bind(this);
        initToolBar(title,"修改密码","保存");
    }
}
