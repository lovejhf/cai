package com.ntcai.ntcc.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aries.ui.view.radius.RadiusTextView;
import com.hjq.toast.ToastUtils;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.util.AppManager;
import com.ntcai.ntcc.util.Constant;
import com.ntcai.ntcc.view.ClearEditText;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zrq.spanbuilder.Spans;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;

public class MobileQuickLoginActivity extends BaseActivity implements PlatformActionListener,Handler.Callback {
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
    private Platform platform;
    private Handler handler;
    private static final int MSG_AUTH_CANCEL = 2;
    private static final int MSG_AUTH_ERROR = 3;
    private static final int MSG_AUTH_COMPLETE = 4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_login);
        ButterKnife.bind(this);
        Spannable spannable = Spans.builder().text("登录/注册即代表同意", 10, ContextCompat.getColor(this, R.color.color_999999))
                .text("《菜菜网用户注册协议》", 10, ContextCompat.getColor(this, R.color.color_999999)).underLine().build();
        registerAgree.setText(spannable);
        handler = new Handler(this);
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
                platform = ShareSDK.getPlatform(Wechat.NAME);
                authorize(platform);
                platform.removeAccount(true);
//                intent = new Intent(this, WeChartCheckMobile.class);
//                startActivity(intent);
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

    private void authorize(Platform plat) {
        if (plat == null) {
            return;
        }
        plat.setPlatformActionListener(this);
        //关闭SSO授权
        plat.SSOSetting(false);
        plat.showUser(null);
    }


    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        if (i == Platform.ACTION_USER_INFOR) {
            Message msg = new Message();
            msg.what = MSG_AUTH_COMPLETE;
            msg.obj = new Object[]{platform.getName(), hashMap};
            handler.sendMessage(msg);
        }
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        if (i == Platform.ACTION_USER_INFOR) {
            handler.sendEmptyMessage(MSG_AUTH_ERROR);
        }
        throwable.printStackTrace();
    }

    @Override
    public void onCancel(Platform platform, int i) {
        if (i == Platform.ACTION_USER_INFOR) {
            handler.sendEmptyMessage(MSG_AUTH_CANCEL);
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_AUTH_CANCEL: {
                //取消授权
                ToastUtils.show("授权操作已取消");
            }
            break;
            case MSG_AUTH_ERROR: {
                //授权失败
                ToastUtils.show("需要下载微信端");
            }
            break;
            case MSG_AUTH_COMPLETE: {
                String gender = "";
//                ThirdLoginUserInfo userInfo = new ThirdLoginUserInfo();
                if (platform != null) {
                    try {
                        gender = platform.getDb().getUserGender();
                        if (gender.equals("m")) {
//                            userInfo.setUserGender(ThirdLoginUserInfo.Gender.BOY);
//                            genderNum = 1;
                        } else {
//                            userInfo.setUserGender(ThirdLoginUserInfo.Gender.GIRL);
//                            genderNum = 2;
                        }
                    } catch (Exception e) {
                    }

//                    userInfo.setUserIcon(platform.getDb().getUserIcon());
//                    userInfo.setUserName(platform.getDb().getUserName());
//                    userInfo.setUserNote(platform.getDb().getUserId());
//                    userInfo.setPlatformName(platform.getName());
//                    userInfo.setGender(genderNum);
//                    openId = platform.getDb().getUserId();
//                    Util.saveSharedPreferences(this, Constant.LoginIcon, platform.getDb().getUserIcon());
//                    Util.saveSharedPreferences(this, Constant.PlatformName, platform.getName());
//                    Util.saveSharedPreferences(this, Constant.OpenId, platform.getDb().getUserId());
//                    Util.saveSharedPreferences(this, Constant.Gender, String.valueOf(genderNum));
//                    UserPreference userPreference = Treasure.get(this, UserPreference.class);
//                    userPreference.setLoginThread(userInfo);
//                    thirdLogin = true;

                    if (platform.getName().equals("QQ")) {
//                        type = "3";
                    } else if (platform.getName().equals("Wechat")) {
//                        type = "4";
                    } else if (platform.getName().equals("SinaWeibo")) {
//                        type = "5";
                    }
//                    mPresenter.login("", "", "1", platform.getDb().getUserId(), "", type);
//                    mPresenter.thirdLogin(platform.getDb().getUserId(), platform.getDb().getUserName(), platform.getDb().getUserIcon(), genderNum, platform.getName(), platform);
                }
                break;
            }
        }
        return false;
    }
}
