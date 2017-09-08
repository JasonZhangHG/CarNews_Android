package com.example.carman.base;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carman.R;
import com.example.library.base.BaseActivity;

public class BaseBarActivity extends BaseActivity implements View.OnClickListener{

   private ImageView ivBaseActivityBack;
    private TextView tvBaseActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_bar_actiivty);
        ivBaseActivityBack = (ImageView) findViewById(R.id.ivBaseActivityBack);
        tvBaseActivityTitle = (TextView) findViewById(R.id.tvBaseActivityTitle);
        ivBaseActivityBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNavigationIconClick(v);
            }
        });
    }

    @Override
    public int initLayout() {
        return R.layout.activity_base_bar_actiivty;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 返回按钮（title上左边的按钮）点击事件的处理
     *
     * @param v
     */
    public void onNavigationIconClick(View v) {
        finish();
    }

    @Override
    public void setTitle(CharSequence title) {
        tvBaseActivityTitle.setText(title);
    }

    @Override
    public void setTitle(int titleId) {
        tvBaseActivityTitle.setText(titleId);
    }
}
