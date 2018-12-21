package com.ntcai.ntcc.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.aries.ui.view.radius.RadiusTextView;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.view.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingPassWordActivity extends BaseActivity {
    @BindView(R.id.pass_word)
    ClearEditText passWord;
    @BindView(R.id.over)
    RadiusTextView over;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_pass_word);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.over)
    public void onViewClicked() {
    }
}
