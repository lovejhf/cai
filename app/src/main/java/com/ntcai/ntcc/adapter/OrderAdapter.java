package com.ntcai.ntcc.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.bean.OrderVo;
import com.ntcai.ntcc.ui.activity.OrderDetailActivity;

import java.util.List;

public class OrderAdapter extends BaseQuickAdapter<OrderVo,BaseViewHolder> {
    public OrderAdapter(int layoutResId, @Nullable List<OrderVo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderVo item) {
        helper.setText(R.id.order_no,item.getOrder_no());
        helper.setText(R.id.order_status,"交易关闭");
        RecyclerView goodsList = helper.getView(R.id.goods_list);
        goodsList.setLayoutManager(new LinearLayoutManager(mContext));
        OrderGoodsAdapter adapter = new OrderGoodsAdapter(R.layout.item_order_goods,item.getGoods());
        goodsList.setAdapter(adapter);
        LinearLayout rootView = helper.getView(R.id.rootView);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,OrderDetailActivity.class);
                mContext.startActivity(intent);
            }
        });
        goodsList.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent intent = new Intent(mContext,OrderDetailActivity.class);
                    mContext.startActivity(intent);
                }
                return false;
            }
        });
    }
}
