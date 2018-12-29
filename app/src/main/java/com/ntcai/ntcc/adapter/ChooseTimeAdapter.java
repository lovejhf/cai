package com.ntcai.ntcc.adapter;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;

import java.util.List;

public class ChooseTimeAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    private int selection;

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public ChooseTimeAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        TextView textView = helper.getView(R.id.time);
        textView.setText(item);
        if (selection==helper.getAdapterPosition()){
            textView.setTextColor(ContextCompat.getColor(mContext,R.color.color_02C761));

        }else {
            textView.setTextColor(ContextCompat.getColor(mContext,R.color.color_666666));

        }
        if (selection==helper.getAdapterPosition()&&!item.contains("配送")){
            textView.setBackgroundResource(R.color.window_color);
        }else {
            textView.setBackgroundResource(R.color.white);
        }
        if (item.contains("配送")){
            textView.setBackgroundResource(R.color.window_color);
        }
    }
}
