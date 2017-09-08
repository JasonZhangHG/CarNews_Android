package com.example.library.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.library.R;
import com.example.library.control.ActivityControl;

/**
 * Created by admin on 2017/4/28.
 * <p>
 * 所有 activity 共性的代码 的抽取
 * <p>
 * 1. 布局控件初始化
 * 2. activity之间的跳转
 * 3. titleBar
 */

public abstract class BaseActivity extends FragmentActivity {

    private ImageView ivBaseActivityBack;
    private TextView tvBaseActivityTitle;

    private FragmentManager supportFragmentManager;
    private LayoutInflater inflater;
    private TextView center_tv;
    private TextView right_tv;
    private TextView left_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportFragmentManager = this.getSupportFragmentManager();
        inflater = this.getLayoutInflater();
        int layout = initLayout();

        // 如果 这个应用是 true 并且 当前 activity也是 true  说明 使用 titleBar
        if (TitleBarConfig.isUserTitleBar && isUseTitleBar()) {

            addTitleBar(layout);

        } else {
            setContentView(layout);
        }


        initView();

        initData();
        // 因为 每当 activity创建的时候 会执行 onCreate 因此可以在父类中的onCreate方法中写
        ActivityControl.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityControl.removeActivity(this);

    }

    // 添加 titleBar 操作
    public void addTitleBar(int layout) {
        LinearLayout linearLayout = new LinearLayout(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        View view = inflater.inflate(TitleBarConfig.titleBarId, linearLayout, false);
        linearLayout.addView(view);

        View view1 = inflater.inflate(layout, linearLayout, false);

        linearLayout.addView(view1);

        setContentView(linearLayout);

        // 先给titleBar规定上 固定 id  然后在具体实现
        center_tv = (TextView) view.findViewById(R.id.center_id);
        right_tv = (TextView) view.findViewById(R.id.right_id);
        left_tv = (TextView) view.findViewById(R.id.left_id);
//        View.GONE 将 位置也隐藏掉
        left_tv.setVisibility(View.INVISIBLE);// 设置隐藏但是位置不消失
        right_tv.setVisibility(View.INVISIBLE);

    }


    // 给 titleBar的左tv设置 内容
    public void setLeftText(String text) {
        setLeftText(text, null);

    }

    public void setLeftText(String text, View.OnClickListener onClickListener) {

        if (text != null) {
            // 如果要使用 左右tv ，肯定需要显示出来因此我们可以在这里写显示操作
            left_tv.setVisibility(View.VISIBLE);
            left_tv.setText(text);
        }
        if (onClickListener != null) {
            left_tv.setOnClickListener(onClickListener);
        }

    }


    public void setRightText(String text, View.OnClickListener onClickListener) {

        if (text != null) {
            right_tv.setVisibility(View.VISIBLE);

            right_tv.setText(text);
        }

        if (onClickListener != null) {
            right_tv.setOnClickListener(onClickListener);
        }

    }


    public void setRightText(String text) {
        setRightText(text, null);
    }


    public void setCenterText(String text) {
        center_tv.setText(text);
    }


    // 用于 判断  当前activity是否使用 titleBar
    public boolean isUseTitleBar() {

        return true;
    }


    // 初始化 每个 activity的 布局 文件
    public abstract int initLayout();

    //  做 view 的初始化
    public abstract void initView();

    // 数据的初始化

    public abstract void initData();


    // 封装跳转
    public void gotoActivity(Class clazz) {

        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }


    //  封装 fragment 的操作 add  remove , show hide replace

    public void addFragment(int viewId, BaseFragment baseFragment) {
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.add(viewId, baseFragment, baseFragment.tag);
        transaction.commit();
    }


    public void removeFragment(BaseFragment baseFragment) {

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.remove(baseFragment);
        transaction.commit();
    }

    public void showFragment(BaseFragment baseFragment) {
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.show(baseFragment);
        transaction.commit();
    }

    public void hideFragment(BaseFragment baseFragment) {
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.hide(baseFragment);
        transaction.commit();

    }

    public void replaceFragment(int viewId, BaseFragment baseFragment) {
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(viewId, baseFragment);
        transaction.commit();
    }

    // 添加回退栈....

}
