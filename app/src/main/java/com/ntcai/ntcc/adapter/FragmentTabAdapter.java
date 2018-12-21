package com.ntcai.ntcc.adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ntcai.ntcc.R;
import com.ntcai.ntcc.ui.activity.LoginActivity;

import java.util.List;


public class FragmentTabAdapter implements View.OnClickListener {
    private List<Fragment> fragments; // 一个tab页面对应一个Fragment
    private RadioGroup rgs; // 用于切换tab
    private FragmentActivity fragmentActivity; // Fragment所属的Activity
    private int fragmentContentId; // Activity中所要被替换的区域的id
    private int currentTab; // 当前Tab页面索引
    int[] un_checked_draw = new int[]{R.mipmap.ic_home, R.mipmap.ic_home_2, R.mipmap.ic_home_cart, R.mipmap.ic_mine};
    int[] checked_draw = new int[]{R.mipmap.ic_home_n, R.mipmap.ic_home_2_n, R.mipmap.ic_home_cart_n, R.mipmap.ic_mine_n};

    private boolean isLogin = false;

    public FragmentTabAdapter(FragmentActivity fragmentActivity, List<Fragment> fragments, int fragmentContentId, RadioGroup rgs) {
        this.fragments = fragments;
        this.rgs = rgs;
        this.fragmentActivity = fragmentActivity;
        this.fragmentContentId = fragmentContentId;

        // 默认显示第1页
        currentTab = 0;
        FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
        ft.add(fragmentContentId, fragments.get(0));
        ft.commit();
        setCheckedDrawTop(0);
        for (int i = 0; i < 4; i++) {
            rgs.getChildAt(i).setOnClickListener(this);

        }
    }

    Fragment fragment;
    FragmentTransaction ft;
    int index;
    int before;

    @Override
    public void onClick(View v) {
        index = getIndex(v.getId());
        before = index;
        if (isLogin){
            if (index == 2 || index == 3 ) {
                Intent intent = new Intent(fragmentActivity, LoginActivity.class);
                fragmentActivity.startActivity(intent);
                fragmentActivity.overridePendingTransition(R.anim.bottom_in,R.anim.bottom_silent);
                return;
            }
        }

        if (currentTab == index) {
            return;
        }
        fragment = fragments.get(index);
        getCurrentFragment().onPause(); // 暂停当前tab
        setCheckedDrawTop(index);
        startFragment(index);

    }

    public void setCheckedDrawTop(int index) {
        for (int i = 0; i < 4; i++) {
            RadioButton rb = (RadioButton) rgs.getChildAt(i);
            if (i == index) {
                Drawable drawable = fragmentActivity.getResources().getDrawable(checked_draw[i]);
                rb.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                rb.setTextColor(fragmentActivity.getResources().getColor(R.color.color_02A44F));
            } else {
                Drawable drawable = fragmentActivity.getResources().getDrawable(un_checked_draw[i]);
                rb.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                rb.setTextColor(fragmentActivity.getResources().getColor(R.color.color_D8D8D8));
            }
        }
    }


    public void startFragment(int index) {
        FragmentTransaction ft = obtainFragmentTransaction(index);
        Fragment fragment = fragments.get(index);
        if (fragment.isAdded()) {
            fragment.onResume(); // 启动目标tab的onResume()
        } else {
            ft.add(fragmentContentId, fragment);
        }
        showTab(index); // 显示目标tab
        ft.commit();
    }


    private int getIndex(int checkedId) {
        switch (checkedId) {
            case R.id.tab_home:
                return 0;
            case R.id.tab_find:
                return 1;
            case R.id.tab_cart:
                return 2;
            case R.id.tab_mine:
                return 3;
        }
        return 0;
    }

    /**
     * 切换tab
     *
     * @param idx
     */
    public void showTab(int idx) {
        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            FragmentTransaction ft = obtainFragmentTransaction(idx);
            if (idx == i) {
                ft.show(fragment);
            } else {
                ft.hide(fragment);
            }
            ft.commitAllowingStateLoss();
        }
        currentTab = idx; // 更新目标tab为当前tab
    }


    /**
     * 获取一个带动画的FragmentTransaction
     *
     * @param index
     * @return
     */
    private FragmentTransaction obtainFragmentTransaction(int index) {
        FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
        // 设置切换动画
        if (index > currentTab) {
            ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
        } else {
            ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out);
        }
        return ft;
    }

    public int getCurrentTab() {
        return currentTab;
    }

    public Fragment getCurrentFragment() {
        return fragments.get(currentTab);
    }

    public interface onRadioButtonClickListener {
        void onClickListener(int p);
    }
}
