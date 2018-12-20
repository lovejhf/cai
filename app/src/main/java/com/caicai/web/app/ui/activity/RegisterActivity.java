package com.caicai.web.app.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.widget.TextView;

import com.caicai.web.app.BaseActivity;
import com.caicai.web.app.R;
import com.hjq.bar.TitleBar;
import com.zrq.spanbuilder.Spans;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.register_agree)
    TextView registerAgree;
    @BindView(R.id.title)
    TitleBar title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initToolBar(title,"注册");
        Spannable spannable = Spans.builder().text("注册代表您同意", 13, ContextCompat.getColor(this, R.color.color_999999))
                .text("《用户注册协议》", 13, ContextCompat.getColor(this, R.color.login_color)).underLine().build();
        registerAgree.setText(spannable);
    }
}
