package com.ntcai.ntcc.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ntcai.ntcc.BaseFragment;
import com.ntcai.ntcc.CallBackValue;
import com.ntcai.ntcc.CheckListener;
import com.ntcai.ntcc.R;
import com.ntcai.ntcc.adapter.ClassifyDetailAdapter;
import com.ntcai.ntcc.bean.CategoryTwoArray;
import com.ntcai.ntcc.bean.RightGoodVo;
import com.ntcai.ntcc.bean.SortVo;
import com.ntcai.ntcc.util.ItemHeaderDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SortDetailFragment extends BaseFragment implements CheckListener {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private View rootView;
    private CheckListener checkListener;
    private ItemHeaderDecoration mDecoration;
    private LinearLayoutManager mManager;
    private List<RightGoodVo> mDatas = new ArrayList<>();
    private int mIndex = 0;
    private boolean move = false;
    private ClassifyDetailAdapter mAdapter;
    private CallBackValue callBackValue;
    public CheckListener getCheckListener() {
        return checkListener;
    }

    public void setCheckListener(CheckListener checkListener) {
        this.checkListener = checkListener;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callBackValue = (CallBackValue) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_sort_detail, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mManager);
        rv.addOnScrollListener(new RecyclerViewListener());
        List<SortVo> rightList = (List<SortVo>) getArguments().getSerializable("right");
        for (int i = 0; i < rightList.size(); i++) {
            RightGoodVo head = new RightGoodVo(rightList.get(i).getName());
            head.setTitleName(rightList.get(i).getName());
            head.setTag(String.valueOf(i));
            head.setTitle(true);
            mDatas.add(head);
            List<CategoryTwoArray> categoryTwoArray = rightList.get(i).getCategoryTwoArray();
            for (int j = 0; j < categoryTwoArray.size(); j++) {
                RightGoodVo body = new RightGoodVo(categoryTwoArray.get(j).getName());
                body.setTag(String.valueOf(i));
                String name = rightList.get(i).getName();
                body.setTitleName(name);
                mDatas.add(body);
            }
        }
        mAdapter = new ClassifyDetailAdapter(mDatas);
        rv.setAdapter(mAdapter);
        mDecoration = new ItemHeaderDecoration(getActivity(), mDatas);
        rv.addItemDecoration(mDecoration);
        mDecoration.setCheckListener(checkListener);
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                callBackValue.onAddAnimal(view);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void check(int position, boolean isScroll) {
        checkListener.check(position, isScroll);
    }

    public void setData(int n) {
        mIndex = n;
        rv.stopScroll();
        smoothMoveToPosition(n);
    }
    private void smoothMoveToPosition(int n) {
        int firstItem = mManager.findFirstVisibleItemPosition();
        int lastItem = mManager.findLastVisibleItemPosition();
        Log.d("first--->", String.valueOf(firstItem));
        Log.d("last--->", String.valueOf(lastItem));
        if (n <= firstItem) {
            rv.scrollToPosition(n);
        } else if (n <= lastItem) {
            Log.d("pos---->", String.valueOf(n) + "VS" + firstItem);
            int top = rv.getChildAt(n - firstItem).getTop();
            Log.d("top---->", String.valueOf(top));
            rv.scrollBy(0, top);
        } else {
            rv.scrollToPosition(n);
            move = true;
        }
    }
    private class RecyclerViewListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (move && newState == RecyclerView.SCROLL_STATE_IDLE) {
                move = false;
                int n = mIndex - mManager.findFirstVisibleItemPosition();
                Log.d("n---->", String.valueOf(n));
                if (0 <= n && n < rv.getChildCount()) {
                    int top = rv.getChildAt(n).getTop();
                    Log.d("top--->", String.valueOf(top));
                    rv.smoothScrollBy(0, top);
                }
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (move) {
                move = false;
                int n = mIndex - mManager.findFirstVisibleItemPosition();
                if (0 <= n && n < rv.getChildCount()) {
                    int top = rv.getChildAt(n).getTop();
                    rv.scrollBy(0, top);
                }
            }
        }
    }

}
