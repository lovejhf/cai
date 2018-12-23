package com.ntcai.ntcc.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.SettingAdapter;
import com.ntcai.ntcc.dialog.HeadpicSelectDialog;
import com.ntcai.ntcc.dialog.ModifySexDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {
    @BindView(R.id.setting_recycler_view)
    RecyclerView settingRecyclerView;
    @BindView(R.id.title)
    TitleBar title;
    @BindView(R.id.show_selected_header_pic)
    LinearLayout showSelectedHeaderPic;
    @BindView(R.id.login_out)
    TextView loginOut;
    private HeadpicSelectDialog headpicSelectDialog;
    private ModifySexDialog modifySexDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initToolBar(title, "设置","");
        settingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        SettingAdapter settingAdapter = new SettingAdapter(R.layout.item_setting_menu, getMenus());
        settingRecyclerView.setAdapter(settingAdapter);
        headpicSelectDialog = new HeadpicSelectDialog(this, new HeadpicSelectDialog.OnHeadpicSelectHandler() {
            @Override
            public void onTakepicSelect() {

            }

            @Override
            public void onAlbumSelect() {

            }

        });
        modifySexDialog = new ModifySexDialog(this, new ModifySexDialog.OnHeadpicSelectHandler() {
            @Override
            public void onMale() {

            }

            @Override
            public void onFemale() {

            }

        });
        settingAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = null;
                switch (getMenus().get(position).first){
                    case "用户名":
                        intent = new Intent(SettingActivity.this,ModifyUserNameActivity.class);
                        startActivity(intent);
                        break;
                    case "性别":
                        if (modifySexDialog!=null&&!modifySexDialog.isShowing()){
                            modifySexDialog.show();
                        }
                        break;
                    case "手机号":
                        intent = new Intent(SettingActivity.this,ModifyMobileActivity.class);
                        startActivity(intent);
                        break;
                    case "修改密码":
                        intent = new Intent(SettingActivity.this,ModifyPassWord.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    private List<Pair<String, String>> getMenus() {
        List<Pair<String, String>> menus = new ArrayList<>();
        menus.add(new Pair<>("用户名", "lockie"));
        menus.add(new Pair<>("性别", "男"));
        menus.add(new Pair<>("手机号", "139*****8291"));
        menus.add(new Pair<>("修改密码", ""));
        return menus;
    }

    @OnClick({R.id.show_selected_header_pic, R.id.login_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.show_selected_header_pic:
                if (headpicSelectDialog!=null&&!headpicSelectDialog.isShowing()){
                    headpicSelectDialog.show();
                }
                break;
            case R.id.login_out:
                break;
        }
    }
}
