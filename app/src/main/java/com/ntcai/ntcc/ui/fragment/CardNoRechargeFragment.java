package com.ntcai.ntcc.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ntcai.ntcc.BaseFragment;
import com.ntcai.ntcc.R;

public class CardNoRechargeFragment extends BaseFragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView==null){
            rootView = inflater.inflate(R.layout.fragment_card_no_recharge,container,false);
        }
        return rootView;
    }
}
