package com.ntcai.ntcc.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.allen.library.CircleImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ntcai.ntcc.BaseFragment;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.MineMenuOrderAdapter;
import com.ntcai.ntcc.adapter.OrderMenuAdapter;
import com.ntcai.ntcc.bean.MineOrderVo;
import com.ntcai.ntcc.ui.activity.AddressActivity;
import com.ntcai.ntcc.ui.activity.CouponActivity;
import com.ntcai.ntcc.ui.activity.MessageActivity;
import com.ntcai.ntcc.ui.activity.MineIntegralActivity;
import com.ntcai.ntcc.ui.activity.MineOrderActivity;
import com.ntcai.ntcc.ui.activity.SettingActivity;
import com.ntcai.ntcc.ui.activity.UserAccountActivity;
import com.ntcai.ntcc.view.ItemPositionDecoration;
import com.zrq.spanbuilder.Spans;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MineFragment extends BaseFragment {
    Unbinder unbinder;
    @BindView(R.id.mine_order_menu)
    RecyclerView mineOrderMenu;
    @BindView(R.id.mine_menu_list)
    RecyclerView mineMenuList;
    @BindView(R.id.header)
    CircleImageView header;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.tool_bar_layout)
    RelativeLayout toolBarLayout;
    @BindView(R.id.message)
    ImageView message;
    @BindView(R.id.all_order)
    TextView allOrder;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_mine, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mineOrderMenu.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        OrderMenuAdapter orderMenuAdapter = new OrderMenuAdapter(R.layout.item_order_status, getMenus());
        orderMenuAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(),MineOrderActivity.class);
                intent.putExtra("position",position+1);
                startActivity(intent);
            }
        });
        mineOrderMenu.setAdapter(orderMenuAdapter);
        mineMenuList.setLayoutManager(new LinearLayoutManager(getActivity()));
        final MineMenuOrderAdapter mineMenuOrderAdapter = new MineMenuOrderAdapter(R.layout.item_mine_menu, getMineMenus());
        mineMenuList.setAdapter(mineMenuOrderAdapter);
        mineMenuList.addItemDecoration(new ItemPositionDecoration());
        ImmersionBar.setTitleBar(getActivity(), toolBarLayout);
        Spannable spannable = Spans.builder().text("userName", 16, Color.WHITE)
                .text("\n187****0068", 12, Color.WHITE).build();
        userName.setText(spannable);

        mineMenuOrderAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = null;
                switch (mineMenuOrderAdapter.getData().get(position).getName()) {
                    case "我的账户":
                        intent = new Intent(getActivity(),UserAccountActivity.class);
                        startActivity(intent);
                        break;
                    case "优惠券":
                        intent = new Intent(getActivity(),CouponActivity.class);
                        startActivity(intent);
                        break;
                    case "地址管理":
                        intent = new Intent(getActivity(),AddressActivity.class);
                        startActivity(intent);
                        break;
                    case "邀请好友":
                        break;
                    case "购菜指南":
                        break;
                    case "意见反馈":
                        break;
                    case "我的积分":
                        intent= new Intent(getActivity(),MineIntegralActivity.class);
                        startActivity(intent);
                        break;
                    case "设置":
                        intent = new Intent(getActivity(), SettingActivity.class);
                        startActivity(intent);
                        break;

                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private List<Pair<String, Integer>> getMenus() {
        List<Pair<String, Integer>> menus = new ArrayList<>();
        menus.add(new Pair<>("未付款", R.mipmap.ic_order_unpaid));
        menus.add(new Pair<>("待发货", R.mipmap.ic_order_un_delivery));
        menus.add(new Pair<>("已发货", R.mipmap.ic_order_shipped));
        menus.add(new Pair<>("已完成", R.mipmap.ic_order_complete));
        return menus;
    }

    private List<MineOrderVo> getMineMenus() {
        List<MineOrderVo> menus = new ArrayList<>();
        menus.add(new MineOrderVo(R.mipmap.ic_mine_account, "我的账户", "1000"));
        menus.add(new MineOrderVo(R.mipmap.ic_mine_integral, "我的积分", "1000"));
        menus.add(new MineOrderVo(R.mipmap.ic_mine_coupon, "优惠券", ""));
        menus.add(new MineOrderVo(R.mipmap.ic_mine_address, "地址管理", ""));
        menus.add(new MineOrderVo(R.mipmap.ic_mine_invite_frind, "邀请好友", "邀请好友享优惠"));
        menus.add(new MineOrderVo(R.mipmap.ic_buy_guide, "购菜指南", ""));
        menus.add(new MineOrderVo(R.mipmap.ic_mine_opinion, "意见反馈", "发表您宝贵的意见"));
        menus.add(new MineOrderVo(R.mipmap.ic_mine_setting, "设置", ""));
        return menus;
    }

    @OnClick({R.id.message, R.id.all_order})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.message:
                intent = new Intent(getActivity(),MessageActivity.class);
                startActivity(intent);
                break;
            case R.id.all_order:
                intent = new Intent(getActivity(),MineOrderActivity.class);
                startActivity(intent);
                break;
        }
    }
}
