package com.ntcai.ntcc.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.bean.OrderConfirmInfo;

import java.util.List;

public class OrderConfirmInfoAdapter extends BaseQuickAdapter<OrderConfirmInfo,BaseViewHolder> {
    public OrderConfirmInfoAdapter(int layoutResId, @Nullable List<OrderConfirmInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderConfirmInfo item) {
        helper.setText(R.id.key,item.getName());
        TextView value = helper.getView(R.id.value);
        value.setText(item.getKey());
    }
}
