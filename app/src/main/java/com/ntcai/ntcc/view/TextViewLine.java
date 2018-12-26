package com.ntcai.ntcc.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ntcai.ntcc.R;

@SuppressLint("AppCompatCustomView")
public class TextViewLine extends TextView {
    private Paint mPaint = new Paint();
    private int lineColor;
    public TextViewLine(Context context) {
        super(context);
    }

    public TextViewLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewVerticalLine);
        lineColor = typedArray.getColor(R.styleable.ClearEditText_drawLine,Color.BLACK);//默认黑色

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(15);
        mPaint.setColor(lineColor);
        canvas.drawLine(40,40,40,getHeight() - 40,mPaint);
    }
}
