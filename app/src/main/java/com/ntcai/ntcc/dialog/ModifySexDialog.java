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

public class ModifySexDialog extends Dialog implements DialogInterface,View.OnClickListener{
    Context context;
    OnHeadpicSelectHandler handler;
    public ModifySexDialog(Context context, OnHeadpicSelectHandler handler) {
        super(context, R.style.dialog_select_gender);
        this.context = context;
        this.handler = handler;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setCancelable(false);
        View v = getLayoutInflater().inflate(R.layout.dialog_modify_sex,null);
        TextView layout1 = v.findViewById(R.id.male);
        TextView layout2 =  v.findViewById(R.id.female);
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
            case R.id.male:
                handler.onMale();
                break;
            case R.id.female:
                handler.onFemale();
                break;
            case R.id.cancel:
                dismiss();
                break;
        }
    }

    public interface OnHeadpicSelectHandler{
        public void onMale();
        public void onFemale();
    }
}
