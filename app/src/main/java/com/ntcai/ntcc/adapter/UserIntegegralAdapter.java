package com.ntcai.ntcc.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.bean.UserIntegegraVo;
import com.zrq.spanbuilder.Spans;

import java.util.List;

public class UserIntegegralAdapter extends BaseQuickAdapter<UserIntegegraVo,BaseViewHolder> {
    public UserIntegegralAdapter(int layoutResId, @Nullable List<UserIntegegraVo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserIntegegraVo item) {
        Spannable spannable = Spans.builder().text(item.getName()+"\n",15,Color.BLACK)
                .text(item.getTime(),11,ContextCompat.getColor(mContext, R.color.color_999999))
                .build();
        helper.setText(R.id.key,spannable);
        helper.setText(R.id.value,item.getIntegera()+"");
    }
}
