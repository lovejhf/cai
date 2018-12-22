package com.ntcai.ntcc.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.FragmentTabAdapter;
import com.ntcai.ntcc.ui.fragment.HomeFragment;
import com.ntcai.ntcc.ui.fragment.MineFragment;
import com.ntcai.ntcc.ui.fragment.ShopTypeFragment;
import com.ntcai.ntcc.ui.fragment.ShoppingCartFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.FrameAct_FragmentGroup)
    FrameLayout FrameActFragmentGroup;
    @BindView(R.id.tab_home)
    RadioButton tabHome;
    @BindView(R.id.tab_find)
    RadioButton tabFind;
    @BindView(R.id.tab_cart)
    RadioButton tabCommunity;
    @BindView(R.id.tab_mine)
    RadioButton tabMine;
    @BindView(R.id.RadioG_Bottem)
    RadioGroup RadioGBottem;
    private List<Fragment> list = new ArrayList<>();
    public FragmentTabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list.add(new HomeFragment());
        list.add(new ShopTypeFragment());
        list.add(new ShoppingCartFragment());
        list.add(new MineFragment());
        tabAdapter = new FragmentTabAdapter(this, list, R.id.FrameAct_FragmentGroup, RadioGBottem);
        for (int i = 0; i < RadioGBottem.getChildCount(); i++) {
            if (RadioGBottem.getChildAt(i) instanceof RadioButton) {
                final RadioButton radioButton = (RadioButton) RadioGBottem.getChildAt(i);
                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            setAnimal(radioButton);
                        }
                    }
                });
            }
        }
    }

    private void setAnimal(View view) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "scaleX", 0.75f, 1.3f, 1f, 1.2f, 1f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleY", 0.75f, 1.3f, 1f, 1.2f, 1f);
        set.playTogether(animator1, animator2);
        set.setDuration(800);
        set.start();
    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }
}
