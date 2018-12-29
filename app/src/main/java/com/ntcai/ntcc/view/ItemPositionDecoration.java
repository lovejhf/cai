package com.ntcai.ntcc.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemPositionDecoration extends RecyclerView.ItemDecoration {
    private int position1;
    private int position2;

    public ItemPositionDecoration(int position1, int position2) {
        this.position1 = position1;
        this.position2 = position2;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int pos = parent.getChildAdapterPosition(view);
        if (position1 == pos) {
            outRect.top = 20;
        }else if (position2==pos){
            outRect.top = 20;
        }
    }

}
