package com.ntcai.ntcc.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aries.ui.view.radius.RadiusTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ntcai.ntcc.BaseFragment;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.HomeGoodAdapter;
import com.ntcai.ntcc.adapter.OrderMenuAdapter;
import com.ntcai.ntcc.bean.GoodsVo;
import com.ntcai.ntcc.glide.GlideImageLoader;
import com.ntcai.ntcc.ui.activity.GoodsDetailActivity;
import com.ntcai.ntcc.util.ItemDecorationDivider;
import com.ntcai.ntcc.view.ObservableScrollView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class HomeFragment extends BaseFragment {
    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.type_menu)
    RecyclerView typeMenu;
    @BindView(R.id.day_selected)
    RecyclerView daySelected;
    @BindView(R.id.goods_cart_list)
    RecyclerView goodsCartList;
    @BindView(R.id.type_selected_list)
    RecyclerView typeSelectedList;
    @BindView(R.id.nest_scroll_view)
    ObservableScrollView nestScrollView;
    @BindView(R.id.location)
    RadiusTextView location;
    @BindView(R.id.search_view)
    RadiusTextView searchView;
    private View rootView;
    private List<String> images = new ArrayList<>();
    private int mHeight = 200;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        images.add("https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png");
        images.add("https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png");
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        ImmersionBar.setTitleBar(getActivity(), title);
        typeMenu.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        daySelected.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        OrderMenuAdapter orderMenuAdapter = new OrderMenuAdapter(R.layout.item_order_status, getMenus());
        typeMenu.setAdapter(orderMenuAdapter);

        typeSelectedList.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        HomeGoodAdapter homeGoodAdapter = new HomeGoodAdapter(R.layout.vertical_goods_layout, getGoods1());
        typeSelectedList.setAdapter(homeGoodAdapter);

        HomeGoodAdapter daySeleted = new HomeGoodAdapter(R.layout.item_day_selected_good, getGoods1());
        daySelected.setAdapter(daySeleted);
        daySeleted.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(),GoodsDetailActivity.class);
                startActivity(intent);
            }
        });
        goodsCartList.setLayoutManager(new LinearLayoutManager(getActivity()));
        goodsCartList.addItemDecoration(new ItemDecorationDivider(getActivity(), ItemDecorationDivider.VERTICAL_LIST, 1, ContextCompat.getColor(getActivity(), R.color.divider)));
        HomeGoodAdapter adapter = new HomeGoodAdapter(R.layout.item_classify_detail, getGoods());
        goodsCartList.setAdapter(adapter);
        final Drawable location_grey =getResources().getDrawable(R.mipmap.ic_location);
        final Drawable location_white =getResources().getDrawable(R.mipmap.ic_location_white);

        final Drawable down_grey =getResources().getDrawable(R.mipmap.ic_home_down_grey);
        final Drawable down_white =getResources().getDrawable(R.mipmap.ic_home_down);
        nestScrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                if (y <= 0) {
                    location.setCompoundDrawablesWithIntrinsicBounds(location_white, null, down_white, null);
                    title.setBackgroundColor(Color.TRANSPARENT);
                    searchView.getDelegate().setBackgroundColor(Color.WHITE);
                    location.getDelegate().setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.color_4D000000));
                    location.setTextColor(Color.WHITE);
                } else if (y > 0 && y < mHeight) {
                    float scale = (float) y / mHeight;//算出滑动距离比例
                    float alpha = (255 * scale);//得到透明度
                    title.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                    location.getDelegate().setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
                } else {
                    title.setBackgroundColor(Color.argb(255, 255, 255, 255));
                    location.getDelegate().setBackgroundColor(Color.WHITE);
                    searchView.getDelegate().setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.color_FFEEEEEE));
                    location.setTextColor(ContextCompat.getColor(getActivity(),R.color.home_text_color));
                    location.setCompoundDrawablesWithIntrinsicBounds(location_grey, null, down_grey, null);
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
        menus.add(new Pair<>("净菜烧烤", R.mipmap.ic_home_menu_1));
        menus.add(new Pair<>("水产海鲜", R.mipmap.ic_home_menu_2));
        menus.add(new Pair<>("猪肉羊肉", R.mipmap.ic_home_menu_3));
        menus.add(new Pair<>("新鲜水果", R.mipmap.ic_home_menu_4));
        menus.add(new Pair<>("素菜豆制", R.mipmap.ic_home_menu_5));
        menus.add(new Pair<>("牛奶冻饮", R.mipmap.ic_home_menu_6));
        menus.add(new Pair<>("酱菜调味", R.mipmap.ic_home_menu_7));
        menus.add(new Pair<>("方便面食", R.mipmap.ic_home_menu_8));
        menus.add(new Pair<>("粮油干货", R.mipmap.ic_home_menu_9));
        menus.add(new Pair<>("家禽蛋类", R.mipmap.ic_home_menu_10));
        return menus;
    }

    private List<GoodsVo> getGoods() {
        List<GoodsVo> goodsVos = new ArrayList<>();
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("北联 西红柿", "规格:500g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        return goodsVos;
    }

    private List<GoodsVo> getGoods1() {
        List<GoodsVo> goodsVos = new ArrayList<>();
        goodsVos.add(new GoodsVo("绿地蔬菜", "350g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("绿地蔬菜", "350g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("绿地蔬菜", "350g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("绿地蔬菜", "350g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("绿地蔬菜", "350g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        goodsVos.add(new GoodsVo("绿地蔬菜", "350g/份", 1, 1, "https://yunzc.oss-cn-hangzhou.aliyuncs.com/hd/banner.png", 2));
        return goodsVos;
    }
}
