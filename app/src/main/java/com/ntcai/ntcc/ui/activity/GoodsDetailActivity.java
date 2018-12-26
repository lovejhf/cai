package com.ntcai.ntcc.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.glide.GlideImageLoader;
import com.ntcai.ntcc.view.ObservableScrollView;
import com.tencent.smtt.sdk.WebView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsDetailActivity extends BaseActivity {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.scrollView)
    ObservableScrollView scrollView;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.cart)
    ImageView cart;
    private List<String> images = new ArrayList<>();
    private int mHeight = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        ImmersionBar.setTitleBar(this, title);
        webView.loadUrl("https://blog.csdn.net/valada/article/details/85231526");
        images.add("https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png");
        images.add("https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png");
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        back.setBackgroundResource(R.mipmap.ic_goods_detail_back);
        name.setTextColor(Color.WHITE);
        back.setBackgroundResource(R.mipmap.ic_goods_shop_cart);
        scrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                if (y <= 0) {
                    back.setBackgroundResource(R.mipmap.ic_goods_detail_back);
                    title.setBackgroundColor(Color.TRANSPARENT);
                    name.setTextColor(Color.TRANSPARENT);
                    cart.setBackgroundResource(R.mipmap.ic_goods_shop_cart);
                } else if (y > 0 && y < mHeight) {
                    float scale = (float) y / mHeight;//算出滑动距离比例
                    float alpha = (255 * scale);//得到透明度
                    title.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                } else {
                    title.setBackgroundColor(Color.argb(255, 255, 255, 255));
                    name.setTextColor(Color.BLACK);
                    back.setBackgroundResource(R.mipmap.ic_back);
                    cart.setBackgroundResource(R.mipmap.ic_cart);
                }
            }
        });
    }

}
