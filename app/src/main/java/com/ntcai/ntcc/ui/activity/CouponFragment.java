package com.ntcai.ntcc.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ntcai.ntcc.BaseFragment;
import com.ntcai.ntcc.CallCountValue;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.CouponAdapter;
import com.ntcai.ntcc.bean.CouponVo;
import com.ntcai.ntcc.util.SpaceItemDecoration;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.scwang.smartrefresh.layout.util.DesignUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CouponFragment extends BaseFragment {
    @BindView(R.id.coupon)
    RecyclerView coupon;
    Unbinder unbinder;
    private View rootView;
    private CallCountValue callBackValue;
    private String type;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBackValue = (CallCountValue) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_coupon, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        coupon.setLayoutManager(new LinearLayoutManager(getActivity()));
        coupon.addItemDecoration(new SpaceItemDecoration(DensityUtil.dp2px(10),DensityUtil.dp2px(10),DensityUtil.dp2px(10),DensityUtil.dp2px(0)));

    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        type = getArguments().getString("type");
        switch (type){
            case "可使用":
                List<CouponVo> couponVos = new ArrayList<>();
                couponVos.add(new CouponVo(100,"水果生鲜,全产通用,满100元减10","有效期：2018.12.21-2019.12.22","全场通用",0));
                couponVos.add(new CouponVo(200,"水果生鲜,全产通用,满100元减10","有效期：2018.12.21-2019.12.22","全场通用",0));
                couponVos.add(new CouponVo(200,"水果生鲜,全产通用,满100元减10","有效期：2018.12.21-2019.12.22","全场通用",0));
                couponVos.add(new CouponVo(300,"水果生鲜,全产通用,满100元减10","有效期：2018.12.21-2019.12.22","全场通用",0));
                CouponAdapter   couponAdapter = new CouponAdapter(R.layout.item_coupon,couponVos);
                coupon.setAdapter(couponAdapter);
                callBackValue.setCount( couponVos.size(),type);
                break;
            case"不可用":
                List<CouponVo> couponVos1 = new ArrayList<>();
                couponVos1.add(new CouponVo(100,"水果生鲜,全产通用,满100元减10","有效期：2018.12.21-2019.12.22","全场通用",1));
                couponVos1.add(new CouponVo(200,"水果生鲜,全产通用,满100元减10","有效期：2018.12.21-2019.12.22","全场通用",1));
                couponVos1.add(new CouponVo(200,"水果生鲜,全产通用,满100元减10","有效期：2018.12.21-2019.12.22","全场通用",1));
                couponVos1.add(new CouponVo(300,"水果生鲜,全产通用,满100元减10","有效期：2018.12.21-2019.12.22","全场通用",1));
                CouponAdapter   couponAdapter1 = new CouponAdapter(R.layout.item_coupon,couponVos1);
                coupon.setAdapter(couponAdapter1);
                callBackValue.setCount( couponVos1.size(),type);
                break;
        }



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
