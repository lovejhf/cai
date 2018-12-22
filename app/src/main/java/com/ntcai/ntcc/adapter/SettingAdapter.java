package com.ntcai.ntcc.adapter;

import android.support.annotation.Nullable;
import android.util.Pair;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;

import java.util.List;

public class SettingAdapter extends BaseQuickAdapter<Pair<String,String>,BaseViewHolder> {
    public SettingAdapter(int layoutResId, @Nullable List<Pair<String, String>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Pair<String, String> item) {
            helper.setText(R.id.name,item.first);
            helper.setText(R.id.right_sub,item.second);
    }
}
