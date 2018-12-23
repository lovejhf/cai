package com.ntcai.ntcc.adapter;

import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mcxiaoke.bus.Bus;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.bean.GoodsVo;
import com.ntcai.ntcc.util.Util;
import com.ntcai.ntcc.view.NumberButton;
import com.zrq.spanbuilder.Spans;

import java.util.List;

public class ShoppingCartAdapter extends BaseItemDraggableAdapter<GoodsVo, BaseViewHolder> {
    public ShoppingCartAdapter(List<GoodsVo> data) {
        super(R.layout.item_goods_cart, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final GoodsVo item) {
        helper.setText(R.id.name, item.getGoodsName());
        helper.setText(R.id.sub, item.getSpec());
       NumberButton button =  helper.getView(R.id.number_button);
        Spannable spannable = Spans.builder().text(Util.decimalFormatMoney(item.getPrice()), 15, ContextCompat.getColor(mContext, R.color.color_D0021B))
                .text("/份", 13, ContextCompat.getColor(mContext, R.color.color_999999)).build();
        helper.setText(R.id.price, spannable);
        CheckBox checkBox = helper.getView(R.id.cb_selected);
        checkBox.setChecked(item.isSelecet());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                item.setSelecet(isChecked);
                Bus.getDefault().post(mData);
            }
        });

        button.setOnAddSubListener(new NumberButton.OnAddSubListener() {
            @Override
            public void onChangeListener(int count) {
                item.setNum(count);
                Bus.getDefault().post(mData);

            }

        });
    }
}
