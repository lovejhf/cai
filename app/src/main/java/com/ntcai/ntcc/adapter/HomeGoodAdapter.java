package com.ntcai.ntcc.adapter;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.bean.GoodsVo;
import com.ntcai.ntcc.util.Util;
import com.ntcai.ntcc.view.NumberButton;
import com.zrq.spanbuilder.Spans;

import java.util.List;

public class HomeGoodAdapter extends BaseQuickAdapter<GoodsVo, BaseViewHolder> {

    public HomeGoodAdapter(int layoutResId, @Nullable List<GoodsVo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsVo item) {
        helper.setText(R.id.name, item.getGoodsName());
        helper.setText(R.id.sub, item.getSpec());
        Spannable spannable = Spans.builder().text(Util.decimalFormatMoney(item.getPrice()), 15, ContextCompat.getColor(mContext, R.color.color_D0021B))
                .text("/份", 13, ContextCompat.getColor(mContext, R.color.color_999999)).build();
        helper.setText(R.id.price, spannable);

    }
}
