package com.ntcai.ntcc.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;

import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.OrderGoodsAdapter;
import com.ntcai.ntcc.adapter.OrderInfoAdapter;
import com.ntcai.ntcc.bean.GoodsVo;
import com.ntcai.ntcc.util.ItemDecorationDivider;
import com.ntcai.ntcc.view.ObservableScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailActivity extends BaseActivity {

    @BindView(R.id.title)
    TitleBar title;
    @BindView(R.id.order_status)
    CardView orderStatus;
    @BindView(R.id.good_list)
    RecyclerView goodList;
    @BindView(R.id.distribution_info_list)
    RecyclerView distributionInfoList;
    @BindView(R.id.order_info)
    RecyclerView orderInfo;
    @BindView(R.id.nest_scroll_view)
    ObservableScrollView nestScrollView;
    private int mHeight = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ButterKnife.bind(this);
        initToolBar(title, "订单详情", "");
        distributionInfoList.setLayoutManager(new LinearLayoutManager(this));
        orderInfo.setLayoutManager(new LinearLayoutManager(this));
        goodList.setLayoutManager(new LinearLayoutManager(this));
        distributionInfoList.addItemDecoration(new ItemDecorationDivider(this, ItemDecorationDivider.VERTICAL_LIST, 1, ContextCompat.getColor(this, R.color.divider)));
        orderInfo.addItemDecoration(new ItemDecorationDivider(this, ItemDecorationDivider.VERTICAL_LIST, 1, ContextCompat.getColor(this, R.color.divider)));
        List<GoodsVo> goodsVos = new ArrayList<>();
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        OrderGoodsAdapter adapter = new OrderGoodsAdapter(R.layout.item_order_goods, goodsVos);
        goodList.setAdapter(adapter);
        View footerView1 = LayoutInflater.from(this).inflate(R.layout.order_detail_footer, null);
        View footerView2 = LayoutInflater.from(this).inflate(R.layout.order_detail_footer_amount, null);
        adapter.addFooterView(footerView1);
        adapter.addFooterView(footerView2);
        List<Pair<String, String>> pairs = new ArrayList<>();
        pairs.add(new Pair<>("配送信息：", ""));
        pairs.add(new Pair<>("送达时间：", "立即送达"));
        pairs.add(new Pair<>("配送地址：", "陈云 139****2398\n崇川区五一路天一家园12栋22号"));
        pairs.add(new Pair<>("配送方式：", "配送"));
        OrderInfoAdapter orderInfoAdapter = new OrderInfoAdapter(R.layout.item_order_info, pairs);
        distributionInfoList.setAdapter(orderInfoAdapter);

        List<Pair<String, String>> pairs1 = new ArrayList<>();
        pairs1.add(new Pair<>("订单信息：", ""));
        pairs1.add(new Pair<>("订单编号：", "8938390928199291"));
        pairs1.add(new Pair<>("下单时间：", "2018.12.22 09:22:34"));
        pairs1.add(new Pair<>("支付方式：", "微信支付"));
        OrderInfoAdapter orderInfoAdapter1 = new OrderInfoAdapter(R.layout.item_order_info, pairs1);
        orderInfo.setAdapter(orderInfoAdapter1);
        nestScrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
             if (y < mHeight) {
                    float scale = (float) y / mHeight;//算出滑动距离比例
                    float alpha = (255 * scale);//得到透明度
                    title.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                    title.setLeftIcon(R.mipmap.bar_icon_back_white);
                 title.setTitleColor(Color.WHITE);
                 title.setLineColor(ContextCompat.getColor(OrderDetailActivity.this,R.color.bar_transparent));
                }else {
                    title.setLineColor(ContextCompat.getColor(OrderDetailActivity.this,R.color.color_ccc));
                    title.setTitleColor(Color.BLACK);
                    title.setLeftIcon(R.mipmap.bar_icon_back_black);
                    title.setBackgroundColor(Color.argb(255, 255, 255, 255));
                }
            }
        });

    }
}
