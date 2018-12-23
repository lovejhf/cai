package com.ntcai.ntcc.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.bean.FooTypeVo;

import java.util.List;

public class FoodTypeAdapter extends BaseQuickAdapter<FooTypeVo,BaseViewHolder> {
    public FoodTypeAdapter(int layoutResId, @Nullable List<FooTypeVo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FooTypeVo item) {
        helper.setText(R.id.name,item.getName());
    }
}
