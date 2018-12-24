package com.ntcai.ntcc.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.util.Pair;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;
import com.zrq.spanbuilder.Spans;
import com.zrq.spanbuilder.TextStyle;

import java.util.List;

public class OrderInfoAdapter extends BaseQuickAdapter<Pair<String,String>,BaseViewHolder> {
    public OrderInfoAdapter(int layoutResId, @Nullable List<Pair<String, String>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Pair<String, String> item) {
        Spannable spannable = Spans.builder().text(item.first,13,Color.BLACK).style(TextStyle.BOLD).build();
        Spannable spannable1 = Spans.builder().text(item.first,12,ContextCompat.getColor(mContext,R.color.home_text_color)).build();
            if (helper.getLayoutPosition()==0){
                helper.setText(R.id.key,spannable);
            }else {
                helper.setText(R.id.key,spannable1);
            }

            helper.setText(R.id.value,item.second);
    }
}
