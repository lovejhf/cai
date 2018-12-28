package com.ntcai.ntcc.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int space_left;
    private int space_right;
    private int space_bottom;
    private int  space_top;
    public SpaceItemDecoration(int space_left,int space_top,int space_right,int space_bottom) {
        this.space_left = space_left;
        this.space_top =space_top;
        this.space_right = space_right;
        this.space_bottom =space_bottom;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space_left;
        outRect.right = space_right;
        outRect.bottom = space_bottom;
        outRect.top = space_top;

    }
}
