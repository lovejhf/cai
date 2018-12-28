package com.ntcai.ntcc.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.bean.CouponVo;
import com.ntcai.ntcc.util.Util;
import com.zrq.spanbuilder.Spans;
import com.zrq.spanbuilder.TextStyle;

import java.util.List;

public class CouponAdapter extends BaseQuickAdapter<CouponVo,BaseViewHolder> {
    public CouponAdapter(int layoutResId, @Nullable List<CouponVo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CouponVo item) {
        Spannable spannable = Spans.builder().text("优惠券\n",10,Color.WHITE)
                .text(Util.decimalFormatMoney(item.getAmount()),22,Color.WHITE).style(TextStyle.BOLD).build();

        TextView amount = helper.getView(R.id.amount);
        TextView name = helper.getView(R.id.name);
        TextView type = helper.getView(R.id.type);
        TextView time = helper.getView(R.id.time);
        amount.setText(spannable);
        name.setText(item.getName());
        type.setText(item.getType());
        time.setText(item.getTime());
        if (item.getStatus()==0){
            amount.setBackgroundResource(R.mipmap.ic_coupon);
            name.setTextColor(ContextCompat.getColor(mContext,R.color.home_text_color));
        }else {
            amount.setBackgroundResource(R.mipmap.ic_coupon_used);
            name.setTextColor(ContextCompat.getColor(mContext,R.color.color_999999));
        }
    }
}
