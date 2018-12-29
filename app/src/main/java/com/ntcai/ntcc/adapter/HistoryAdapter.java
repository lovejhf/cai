package com.ntcai.ntcc.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.db.SearchHistory;

import java.util.List;

public class HistoryAdapter extends BaseQuickAdapter<SearchHistory,BaseViewHolder> {
    public HistoryAdapter(int layoutResId, @Nullable List<SearchHistory> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchHistory item) {
        helper.setText(R.id.name,item.getName());
    }
}
