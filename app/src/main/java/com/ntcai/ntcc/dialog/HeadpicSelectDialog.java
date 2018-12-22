package com.ntcai.ntcc.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.ntcai.ntcc.R;

public class HeadpicSelectDialog extends Dialog implements DialogInterface,View.OnClickListener{
    Context context;
    OnHeadpicSelectHandler handler;
    public HeadpicSelectDialog(Context context, OnHeadpicSelectHandler handler) {
        super(context, R.style.dialog_select_gender);
        this.context = context;
        this.handler = handler;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setCancelable(false);
        View v = getLayoutInflater().inflate(R.layout.dialog_headpic_select,null);
        TextView layout1 = v.findViewById(R.id.headpic_1);
        TextView layout2 =  v.findViewById(R.id.headpic_2);
        TextView layout3 =  v.findViewById(R.id.cancel);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        this.setContentView(v);
        setCanceledOnTouchOutside(true);
        DisplayMetrics dm = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int windowWidth = dm.widthPixels;
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.gravity = Gravity.CENTER|Gravity.BOTTOM;
        lp.width = windowWidth;
        getWindow().setAttributes(lp);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if(handler==null)return;
        switch (v.getId()) {
            case R.id.headpic_1:
                handler.onTakepicSelect();
                break;
            case R.id.headpic_2:
                handler.onAlbumSelect();
                break;
            case R.id.cancel:
                dismiss();
                break;
        }
    }

    public interface OnHeadpicSelectHandler{
        public void onTakepicSelect();
        public void onAlbumSelect();
    }
}
