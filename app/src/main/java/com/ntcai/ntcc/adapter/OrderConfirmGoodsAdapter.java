package com.ntcai.ntcc.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.bean.GoodsVo;
import com.ntcai.ntcc.util.Util;

import java.util.List;

public class OrderConfirmGoodsAdapter extends BaseQuickAdapter<GoodsVo,BaseViewHolder> {
    public OrderConfirmGoodsAdapter(int layoutResId, @Nullable List<GoodsVo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsVo item) {
        helper.setText(R.id.name,item.getGoodsName());
        helper.setText(R.id.sub,item.getSpec());
        helper.setText(R.id.price,"单价:"+Util.decimalFormatMoney(item.getPrice())+"数量:"+item.getNum()+"份");
        helper.setText(R.id.total_amount,Util.decimalFormatMoney(item.getTotalPrice()));
    }
}
