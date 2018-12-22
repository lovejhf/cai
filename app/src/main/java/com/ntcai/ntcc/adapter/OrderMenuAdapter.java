package com.ntcai.ntcc.adapter;

import android.support.annotation.Nullable;
import android.util.Pair;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;

import java.util.List;

public class OrderMenuAdapter extends BaseQuickAdapter<Pair<String,Integer>,BaseViewHolder> {
    public OrderMenuAdapter(int layoutResId, @Nullable List<Pair<String, Integer>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Pair<String, Integer> item) {
        helper.setText(R.id.name,item.first);
        helper.setBackgroundRes(R.id.image,item.second);
    }
}
