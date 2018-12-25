package com.ntcai.ntcc.adapter;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.bean.RightGoodVo;

import java.util.List;

public class ClassifyDetailAdapter extends BaseMultiItemQuickAdapter<RightGoodVo,BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ClassifyDetailAdapter(List<RightGoodVo> data) {
        super(data);
        addItemType(0, R.layout.item_title);//标题
        addItemType(1, R.layout.item_classify_detail);//内容
    }

    @Override
    protected void convert(BaseViewHolder helper, RightGoodVo item) {
        switch (item.getItemType()){
            case 0:
                helper.setText(R.id.tv_title,item.getName());
                break;
            case 1:
                helper.setText(R.id.name,item.getName());
                helper.addOnClickListener(R.id.add_cart);
                helper.setText(R.id.sub,item.getSub());
                break;
        }
    }
}
