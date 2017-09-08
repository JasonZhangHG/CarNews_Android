package com.example.carman.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.carman.R;
import com.example.library.base.BaseActivity;

public class Jingx3Activity extends BaseActivity {
    private WebView webView;


    @Override
    public int initLayout() {
        return R.layout.activity_jingx3;
    }

    @Override
    public void initView() {
        webView = (WebView)findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        String uri = getIntent().getStringExtra("data");
        webView.loadUrl(uri);
    }

    @Override
    public void initData() {

    }
}
