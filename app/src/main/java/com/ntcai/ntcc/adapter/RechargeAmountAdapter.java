package com.ntcai.ntcc.adapter;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.aries.ui.view.radius.RadiusTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;

import java.util.List;

public class RechargeAmountAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private int mPosition = 0;

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    public RechargeAmountAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        RadiusTextView radiusTextView = helper.getView(R.id.amount);
        radiusTextView.setText(item);
        if (mPosition == helper.getAdapterPosition()) {
            radiusTextView.getDelegate().setBackgroundColor(ContextCompat.getColor(mContext, R.color.color_26EA4C24));
            radiusTextView.setTextColor(ContextCompat.getColor(mContext, R.color.color_EA4C24));
            radiusTextView.getDelegate().setStrokeColor(ContextCompat.getColor(mContext, R.color.color_EA4C24));
        } else {
            radiusTextView.getDelegate().setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
            radiusTextView.setTextColor(ContextCompat.getColor(mContext, R.color.color_666666));
            radiusTextView.getDelegate().setStrokeColor(ContextCompat.getColor(mContext, R.color.color_999999));
        }
    }

}
