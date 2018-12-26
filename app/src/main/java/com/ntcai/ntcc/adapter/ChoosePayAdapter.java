package com.ntcai.ntcc.adapter;

import android.support.annotation.Nullable;
import android.util.Pair;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;

import java.util.List;

public class ChoosePayAdapter extends BaseQuickAdapter<Pair<String,Integer>,BaseViewHolder> {
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ChoosePayAdapter(int layoutResId, @Nullable List<Pair<String, Integer>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Pair<String, Integer> item) {
        helper.setBackgroundRes(R.id.image,item.second);
        helper.setText(R.id.pay_name,item.first);
        if (position==helper.getAdapterPosition()){
            helper.setBackgroundRes(R.id.status,R.mipmap.ic_check_selected);
        }else {
            helper.setBackgroundRes(R.id.status,R.mipmap.ic_check_normal);
        }
    }
}
