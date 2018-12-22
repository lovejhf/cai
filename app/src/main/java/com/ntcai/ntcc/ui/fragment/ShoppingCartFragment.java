package com.ntcai.ntcc.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseFragment;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.util.Util;
import com.zrq.spanbuilder.Spans;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ShoppingCartFragment extends BaseFragment {
    @BindView(R.id.shopping_cart_list)
    RecyclerView shoppingCartList;
    Unbinder unbinder;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.title)
    TitleBar title;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spannable spannable = Spans.builder().text("合计:", 14, ContextCompat.getColor(getActivity(), R.color.color_999999))
                .text(Util.decimalFormatMoney(2889), 14, ContextCompat.getColor(getActivity(), R.color.color_EA4C24))
                .text("\n(免运费)", 11, ContextCompat.getColor(getActivity(), R.color.color_999999)).build();
        price.setText(spannable);
        ImmersionBar.setTitleBar(getActivity(), title);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
