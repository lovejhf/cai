package com.ntcai.ntcc.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.bean.OrderVo;

import java.util.List;

public class OrderAdapter extends BaseQuickAdapter<OrderVo,BaseViewHolder> {
    public OrderAdapter(int layoutResId, @Nullable List<OrderVo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderVo item) {

    }
}
