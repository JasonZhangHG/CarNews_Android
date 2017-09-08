package com.example.carman.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.carman.R;
import com.example.library.base.BaseActivity;

public class AboutActivity extends BaseActivity {

    @Override
    public int initLayout() {
        return R.layout.activity_about;
    }

    @Override
    public void initView() {
        setCenterText("关于");
    }

    @Override
    public void initData() {

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        return super.onKeyDown(keyCode, event);
    }
}
