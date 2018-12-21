package com.ntcai.ntcc.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.aries.ui.view.radius.RadiusTextView;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WeChartCheckMobile extends BaseActivity {
    @BindView(R.id.getCode)
    TextView getCode;
    @BindView(R.id.next)
    RadiusTextView next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechart_check_mobile);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.getCode, R.id.next})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.getCode:
                break;
            case R.id.next:
                intent = new Intent(this,SettingPassWordActivity.class);
                startActivity(intent);
                break;
        }
    }
}
