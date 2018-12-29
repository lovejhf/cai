package com.ntcai.ntcc.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseActivity;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.OrderConfirmGoodsAdapter;
import com.ntcai.ntcc.adapter.OrderConfirmInfoAdapter;
import com.ntcai.ntcc.bean.GoodsVo;
import com.ntcai.ntcc.bean.OrderConfirmInfo;
import com.ntcai.ntcc.dialog.SelectTimeDialog;
import com.ntcai.ntcc.view.ItemPositionDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderConfirmActivity extends BaseActivity {

    @BindView(R.id.title)
    TitleBar title;
    @BindView(R.id.goods_list)
    RecyclerView goodsList;
    @BindView(R.id.order_info)
    RecyclerView orderInfo;
    @BindView(R.id.choose_time)
    TextView chooseTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);
        ButterKnife.bind(this);
        initToolBar(title, "订单确认", "");
        goodsList.setLayoutManager(new LinearLayoutManager(this));
        List<GoodsVo> goodsVos = new ArrayList<>();
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        OrderConfirmGoodsAdapter adapter = new OrderConfirmGoodsAdapter(R.layout.item_order_confirm, goodsVos);
        goodsList.setAdapter(adapter);
        orderInfo.setLayoutManager(new LinearLayoutManager(this));
        orderInfo.addItemDecoration(new ItemPositionDecoration(4, 5));
        List<OrderConfirmInfo> orderConfirmInfos = new ArrayList<>();
        orderConfirmInfos.add(new OrderConfirmInfo("商品金额", "￥167.00"));
        orderConfirmInfos.add(new OrderConfirmInfo("配送费", "￥167.00"));
        orderConfirmInfos.add(new OrderConfirmInfo("促销优惠", "-￥07.0"));
        orderConfirmInfos.add(new OrderConfirmInfo("优惠券", "-￥5.60"));
        orderConfirmInfos.add(new OrderConfirmInfo("商品余额", "可用余额为：50.0"));
        orderConfirmInfos.add(new OrderConfirmInfo("支付方式", "支付宝"));

        OrderConfirmInfoAdapter orderInfoAdapter = new OrderConfirmInfoAdapter(R.layout.item_order_confirm_info, orderConfirmInfos);
        orderInfo.setAdapter(orderInfoAdapter);
        final SelectTimeDialog dialog= new SelectTimeDialog();
        chooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show(getSupportFragmentManager());
            }
        });
    }

}
