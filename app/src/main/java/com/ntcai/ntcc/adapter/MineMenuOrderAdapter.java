package com.ntcai.ntcc.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.bean.MineOrderVo;

import java.util.List;

public class MineMenuOrderAdapter extends BaseQuickAdapter<MineOrderVo,BaseViewHolder> {
    public MineMenuOrderAdapter(int layoutResId, @Nullable List<MineOrderVo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MineOrderVo item) {
        helper.setText(R.id.name,item.getName());
        helper.setBackgroundRes(R.id.image_recourse,item.getImageRecourse());
        helper.setText(R.id.right_sub,item.getSub());
    }
}
