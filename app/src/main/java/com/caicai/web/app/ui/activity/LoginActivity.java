package com.caicai.web.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aries.ui.view.radius.RadiusTextView;
import com.caicai.web.app.BaseActivity;
import com.caicai.web.app.R;
import com.caicai.web.app.view.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.user_name)
    ClearEditText userName;
    @BindView(R.id.pass_word)
    ClearEditText passWord;
    @BindView(R.id.login)
    RadiusTextView login;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.we_chart_login)
    ImageView weChartLogin;
    @BindView(R.id.qq_login)
    ImageView qqLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login, R.id.register, R.id.we_chart_login, R.id.qq_login})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.login:
                break;
            case R.id.register:
                 intent = new Intent(this,RegisterActivity.class);
                 startActivity(intent);
                break;
            case R.id.we_chart_login:
                break;
            case R.id.qq_login:
                break;
        }
    }
}
