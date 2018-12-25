package com.ntcai.ntcc.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.hjq.bar.TitleBar;
import com.ntcai.ntcc.BaseFragment;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.FoodTypeAdapter;
import com.ntcai.ntcc.bean.FooTypeVo;
import com.ntcai.ntcc.ui.activity.GoodsTypeActivity;
import com.ntcai.ntcc.ui.activity.QuickFoodTypeActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class QuickFoodFragment  extends BaseFragment {
    @BindView(R.id.title)
    ImageView title;
    Unbinder unbinder;
    @BindView(R.id.good_type_list)
    RecyclerView goodTypeList;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_quick_food, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImmersionBar.setTitleBar(getActivity(), title);
        goodTypeList.setLayoutManager(new GridLayoutManager(getActivity(),3));
        FoodTypeAdapter foodTypeAdapter = new FoodTypeAdapter(R.layout.item_food_type,getFoods());
        goodTypeList.setAdapter(foodTypeAdapter);
        foodTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(),QuickFoodTypeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    private List<FooTypeVo> getFoods(){
        List<FooTypeVo>list = new ArrayList<>();
        list.add(new FooTypeVo("海鲜水产"));
        list.add(new FooTypeVo("粮油调味"));
        list.add(new FooTypeVo("面点主食"));
        list.add(new FooTypeVo("肉禽蛋类"));
        list.add(new FooTypeVo("粮油调味"));
        return list;

    }
}
