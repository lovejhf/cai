package com.ntcai.ntcc.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aries.ui.view.radius.RadiusTextView;
import com.gyf.barlibrary.ImmersionBar;
import com.jkb.slidemenu.SlideMenuLayout;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsSerachListActivity extends BaseActivity {
    @BindView(R.id.fm_slide_content)
    LinearLayout fmSlideContent;
    @BindView(R.id.mainSlideMenu)
    SlideMenuLayout mainSlideMenu;
    @BindView(R.id.right_layout)
    ConstraintLayout rightLayout;
    @BindView(R.id.search)
    RadiusTextView search;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.shaixuan)
    TextView shaixuan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        ButterKnife.bind(this);
        ImmersionBar.setTitleBar(this, title);
        rightLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainSlideMenu.toggleRightSlide();
            }
        });
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }

    @Override
    public void onBackPressedSupport() {
        if (mainSlideMenu.isLeftSlideOpen() || mainSlideMenu.isRightSlideOpen()) {
            mainSlideMenu.closeLeftSlide();
            mainSlideMenu.closeRightSlide();
        } else {
            super.onBackPressedSupport();

        }

    }

    @OnClick({R.id.back, R.id.search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.search:
                break;
        }
    }

    @OnClick(R.id.shaixuan)
    public void onViewClicked() {
        mainSlideMenu.toggleRightSlide();
    }
}
