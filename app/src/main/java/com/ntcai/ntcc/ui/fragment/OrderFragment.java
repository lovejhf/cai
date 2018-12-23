package com.ntcai.ntcc.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ntcai.ntcc.BaseFragment;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.bean.GoodsVo;
import com.ntcai.ntcc.bean.OrderVo;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单列表页
 */
public class OrderFragment extends BaseFragment {

    private View rootView;
    private String orderType;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView==null){
            rootView = inflater.inflate(R.layout.fragment_order,container,false);
        }
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orderType = getArguments().getString("orderType");
        switch (orderType){
            case "全部":
                getOrderList("0");
                break;
            case "待付款":
                getOrderList("1");
                break;
            case "待发货":
                getOrderList("2");
                break;
            case "已发货":
                getOrderList("3");
                break;
            case "已完成":
                getOrderList("4");
                break;
        }

    }
    private List<OrderVo>getOrderList(String status){
        List<OrderVo> orderVos = new ArrayList<>();
        List<GoodsVo>goodsVos = new ArrayList<>();
        goodsVos.add(new GoodsVo("北联 西红柿","规格:500g/份",1,1,"https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png",2));
        goodsVos.add(new GoodsVo("北联 西红柿","规格:500g/份",1,1,"https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png",2));
        goodsVos.add(new GoodsVo("北联 西红柿","规格:500g/份",1,1,"https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png",2));
        goodsVos.add(new GoodsVo("北联 西红柿","规格:500g/份",1,1,"https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png",2));
        goodsVos.add(new GoodsVo("北联 西红柿","规格:500g/份",1,1,"https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png",2));
        orderVos.add(new OrderVo("11111",status,6,goodsVos));
        return orderVos;
    }
}
