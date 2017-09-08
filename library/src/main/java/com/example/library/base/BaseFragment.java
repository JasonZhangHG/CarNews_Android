package com.example.library.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.library.R;

/**
 * Created by admin on 2017/4/28.
 */

public abstract class BaseFragment extends Fragment {

    public String tag;
    public View view;
    public BaseActivity activity;
    public LayoutInflater inflater;
    private TextView center_tv;
    private TextView right_tv;
    private TextView left_tv;
    private FragmentManager fragmentManager;


    public BaseFragment() {
        tag = this.getClass().getSimpleName();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        activity = (BaseActivity) getActivity();
        fragmentManager = getFragmentManager();
        int layout = initLayout();

        view = inflater.inflate(layout, container, false);

        if (TitleBarConfig.isUserTitleBar && isUseTitleBar()) {

            addTitleBar(layout);

        }
        initView();

        initData();

        return view;
    }


    public boolean isUseTitleBar() {

        return true;
    }

    public void addTitleBar(int layout) {
        LinearLayout linearLayout = new LinearLayout(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        View view = inflater.inflate(TitleBarConfig.titleBarId, linearLayout, false);
        linearLayout.addView(view);

        View view1 = inflater.inflate(layout, linearLayout, false);

        linearLayout.addView(view1);

        this.view = linearLayout;


        center_tv = (TextView) view.findViewById(R.id.center_id);
        right_tv = (TextView) view.findViewById(R.id.right_id);
        left_tv = (TextView) view.findViewById(R.id.left_id);
        left_tv.setVisibility(View.INVISIBLE);
        right_tv.setVisibility(View.INVISIBLE);


    }

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
        setLeftText(text, null);
    }

    public void setCenterText(String text) {
        center_tv.setText(text);
    }

    public void gotoActivity(Class clazz) {

        Intent intent = new Intent(activity, clazz);
        startActivity(intent);
    }

    public void gotoActivity(Class clazz,String string) {

        Intent intent = new Intent(activity, clazz);
        intent.putExtra("data",string);
        startActivity(intent);
    }


    //  封装 fragment 的操作 add  remove , show hide replace

    public void addFragment(int viewId, BaseFragment baseFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(viewId, baseFragment, baseFragment.tag);
        transaction.commit();
    }


    public void removeFragment(BaseFragment baseFragment) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(baseFragment);
        transaction.commit();
    }

    public void showFragment(BaseFragment baseFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.show(baseFragment);
        transaction.commit();
    }

    public void hideFragment(BaseFragment baseFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(baseFragment);
        transaction.commit();

    }

    public void replace(int viewId, BaseFragment baseFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(viewId, baseFragment);
        transaction.commit();
    }


    public abstract int initLayout();

    public abstract void initView();

    public abstract void initData();


}
