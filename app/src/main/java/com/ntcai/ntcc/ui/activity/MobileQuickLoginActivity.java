package com.ntcai.ntcc.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aries.ui.view.radius.RadiusTextView;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.util.AppManager;
import com.ntcai.ntcc.view.ClearEditText;
import com.zrq.spanbuilder.Spans;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MobileQuickLoginActivity extends BaseActivity {
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.user_name)
    ClearEditText userName;
    @BindView(R.id.login)
    RadiusTextView login;
    @BindView(R.id.uid_login)
    TextView uidLogin;
    @BindView(R.id.we_chart_login)
    ImageView weChartLogin;
    @BindView(R.id.register_agree)
    TextView registerAgree;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_login);
        ButterKnife.bind(this);
        Spannable spannable = Spans.builder().text("登录/注册即代表同意", 10, ContextCompat.getColor(this, R.color.color_999999))
                .text("《菜菜网用户注册协议》", 10, ContextCompat.getColor(this, R.color.color_999999)).underLine().build();
        registerAgree.setText(spannable);
    }

    @OnClick({R.id.register, R.id.login, R.id.uid_login, R.id.we_chart_login, R.id.register_agree})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.register:
                intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login:
                break;
            case R.id.uid_login:
                intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.we_chart_login:
                intent = new Intent(this, WeChartCheckMobile.class);
                startActivity(intent);
                break;
            case R.id.register_agree:
                break;
        }
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
        AppManager.getAppManager().finishActivity(MobileQuickLoginActivity.class);
    }
}
