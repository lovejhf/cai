package com.ntcai.ntcc.dialog;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.ChooseTimeAdapter;

import java.util.ArrayList;
import java.util.List;

import me.shaohui.bottomdialog.BottomDialog;

public class SelectTimeDialog extends BottomDialog {
    private RecyclerView date;
    private RecyclerView time;
    @Override
    public int getLayoutRes() {
        return R.layout.dialog_choose_time;
    }

    @Override
    public void bindView(View v) {
        super.bindView(v);
        date = v.findViewById(R.id.date);
        time =v.findViewById(R.id.time);
        date.setLayoutManager(new LinearLayoutManager(getActivity()));
        time.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<String> dateList = new ArrayList<>();
        dateList.add("今日");
        dateList.add("12月29");
        dateList.add("12月30");
        final ChooseTimeAdapter chooseTimeAdapter = new ChooseTimeAdapter(R.layout.item_choose_time,dateList);
        date.setAdapter(chooseTimeAdapter);
        chooseTimeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                chooseTimeAdapter.setSelection(position);
                chooseTimeAdapter.notifyDataSetChanged();
            }
        });
        List<String> timeList = new ArrayList<>();
        timeList.add("11:00-11:30（配送免费）");
        timeList.add("11:00-12:00（配送免费）");
        timeList.add("12:00-12:30（配送免费）");
        timeList.add("12:30-13:00（配送免费）");
        final ChooseTimeAdapter timeAdapter = new ChooseTimeAdapter(R.layout.item_choose_time,timeList);
        time.setAdapter(timeAdapter);

        timeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                timeAdapter.setSelection(position);
                timeAdapter.notifyDataSetChanged();
            }
        });

    }
}
