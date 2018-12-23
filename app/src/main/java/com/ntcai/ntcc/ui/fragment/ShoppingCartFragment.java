package com.ntcai.ntcc.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.aries.ui.view.radius.RadiusTextView;
import com.gyf.barlibrary.ImmersionBar;
import com.hjq.bar.TitleBar;
import com.mcxiaoke.bus.annotation.BusReceiver;
import com.ntcai.ntcc.BaseFragment;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.ShoppingCartAdapter;
import com.ntcai.ntcc.bean.GoodsVo;
import com.ntcai.ntcc.util.Util;
import com.zrq.spanbuilder.Spans;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.cb_select_num)
    CheckBox cbSelectNum;
    @BindView(R.id.submit)
    RadiusTextView submit;
    private View rootView;
    private List<GoodsVo> datas;
    private boolean kk = true;

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
        setMoeny(0);
        ImmersionBar.setTitleBar(getActivity(), title);
        datas = getGoods();
        final ShoppingCartAdapter shoppingCartAdapter = new ShoppingCartAdapter(datas);
        shoppingCartList.setLayoutManager(new LinearLayoutManager(getActivity()));
        shoppingCartList.setAdapter(shoppingCartAdapter);
        cbSelectNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kk) {
                    for (int i = 0; i < datas.size(); i++) {
                        datas.get(i).setSelecet(true);
                        kk = false;
                    }
                } else {
                    for (int i = 0; i < datas.size(); i++) {
                        datas.get(i).setSelecet(false);
                        kk = true;
                    }
                }
                shoppingCartAdapter.notifyDataSetChanged();
            }
        });

    }

    @BusReceiver
    public void onMainThread(List<GoodsVo> data) {
        double money = 0.0 ;
        List<GoodsVo> selected = new ArrayList<>();
        selected.clear();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).isSelecet()) {
                selected.add(data.get(i));
            }
        }
        submit.setText("结算("+selected.size()+")");

        for (int i = 0; i <selected.size() ; i++) {
            money +=selected.get(i).getNum()*selected.get(i).getPrice();
        }
        setMoeny(money);
        if (selected.size() == 0) {
            kk = true;
            cbSelectNum.setChecked(false);
        } else {
            if (selected.size() == datas.size()) {

                cbSelectNum.setChecked(true);
                kk = false;
            } else {
                kk = true;
                cbSelectNum.setChecked(false);
            }
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private List<GoodsVo> getGoods() {
        List<GoodsVo> goodsVos = new ArrayList<>();
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        return goodsVos;
    }
    private void setMoeny(double money){
        Spannable spannable = Spans.builder().text("合计:", 14, ContextCompat.getColor(getActivity(), R.color.color_999999))
                .text(Util.decimalFormatMoney(money), 14, ContextCompat.getColor(getActivity(), R.color.color_EA4C24))
                .text("\n(免运费)", 11, ContextCompat.getColor(getActivity(), R.color.color_999999)).build();
        price.setText(spannable);
    }
}
