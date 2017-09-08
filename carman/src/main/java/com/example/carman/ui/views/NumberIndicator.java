package com.example.carman.ui.views;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import com.example.carman.R;

/**
 * Created by Administrator on 2017/5/12.
 */

public class NumberIndicator extends TextView {

    public NumberIndicator(Context context) {
        super(context);
        setTextColor(Color.WHITE);
        setTextSize(14);
        setBackgroundResource(R.drawable.text_indicator_bg);
        int padding = DensityUtils.dp2px(context, 5);
        setPadding(padding,padding,padding,padding);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //保证TextIndicator的宽高一致(正方形)
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}