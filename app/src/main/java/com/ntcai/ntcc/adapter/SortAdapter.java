package com.ntcai.ntcc.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.bean.SortVo;

import java.util.List;

public class SortAdapter extends BaseQuickAdapter<SortVo,BaseViewHolder> {
    private int checkedPosition;
    public SortAdapter(int layoutResId, @Nullable List<SortVo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SortVo item) {
        TextView tvSort = helper.getView(R.id.tv_sort);
        tvSort.setText(item.getName());
        if (helper.getLayoutPosition() == checkedPosition) {
            tvSort.setTextColor(ContextCompat.getColor(mContext,R.color.color_02A44F));
            helper.setVisible(R.id.line_type,true);
            helper.setBackgroundColor(R.id.linear_layout,Color.WHITE);
        } else {
            tvSort.setTextColor(ContextCompat.getColor(mContext,R.color.home_text_color));
            helper.setVisible(R.id.line_type,false);
            helper.setBackgroundColor(R.id.linear_layout,Color.TRANSPARENT);
        }
    }

    public void setCheckedPosition(int checkedPosition) {
        this.checkedPosition = checkedPosition;
        notifyDataSetChanged();
    }
}
