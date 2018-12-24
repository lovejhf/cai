package com.ntcai.ntcc.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ntcai.ntcc.BaseFragment;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.OrderAdapter;
import com.ntcai.ntcc.bean.GoodsVo;
import com.ntcai.ntcc.bean.OrderVo;
import com.ntcai.ntcc.ui.activity.OrderDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 订单列表页
 */
public class OrderFragment extends BaseFragment {

    @BindView(R.id.order_list)
    RecyclerView orderList;
    Unbinder unbinder;
    private View rootView;
    private String orderType;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_order, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orderList.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        orderType = getArguments().getString("orderType");
        switch (orderType) {
            case "全部":
                getData("0");
                break;
            case "待付款":
                getData("1");
                break;
            case "待发货":
                getData("2");
                break;
            case "已发货":
                getData("3");
                break;
            case "已完成":
                getData("4");
                break;
        }
    }

    private List<OrderVo> getOrderList(String status) {
        List<OrderVo> orderVos = new ArrayList<>();
        List<GoodsVo> goodsVos = new ArrayList<>();
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        orderVos.add(new OrderVo("11111", status, 6, goodsVos));
        return orderVos;
    }

    private void getData(String status) {
        List<OrderVo> list = getOrderList(status);
        OrderAdapter orderAdapter = new OrderAdapter(R.layout.item_order, list);
        orderList.setAdapter(orderAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
