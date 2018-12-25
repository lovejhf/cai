package com.ntcai.ntcc.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ntcai.ntcc.BaseFragment;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.RechargeAmountAdapter;
import com.ntcai.ntcc.util.GridSpacingItemDecoration;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OnLineRechargeFragment extends BaseFragment {
    @BindView(R.id.amount_list)
    RecyclerView amountList;
    @BindView(R.id.pay_type)
    RecyclerView payType;
    Unbinder unbinder;
    private View rootView;
    private List<String> result = new ArrayList<>();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_online_recharge, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i = 0; i <7 ; i++) {
            result.add((i+1)+"元");
        }
        amountList.setLayoutManager(new GridLayoutManager(getActivity(),3));
        amountList.addItemDecoration(new GridSpacingItemDecoration(3, DensityUtil.dp2px(10), true));
        final RechargeAmountAdapter rechargeAmountAdapter = new RechargeAmountAdapter(R.layout.item_recharge,result);
        amountList.setAdapter(rechargeAmountAdapter);
        rechargeAmountAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                rechargeAmountAdapter.setmPosition(position);
                rechargeAmountAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
