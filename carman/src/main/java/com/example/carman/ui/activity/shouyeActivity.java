package com.example.carman.ui.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.carman.R;
import com.example.carman.base.CarBaseActivity;
import com.example.carman.db.ConstKey;
import com.example.carman.ui.fragment.CarFragment;
import com.example.carman.ui.fragment.FindFragment;
import com.example.carman.ui.fragment.HomeFragment;
import com.example.library.base.BaseActivity;
import com.example.library.base.BaseFragment;

import java.util.ArrayList;
//首页Activity
public class shouyeActivity extends CarBaseActivity implements RadioGroup.OnCheckedChangeListener {

    private TextView mTextMessage;

    private RadioGroup mRg;
    private RadioButton mBarHome;
    private RadioButton mBarCar;
    private RadioButton mBarFind;
    private HomeFragment homeFragment;
    private CarFragment carFragment;
    private FindFragment findFragment;
    private ArrayList<BaseFragment> lists;

    private String userName;



    @Override
    public int initLayout() {
        return R.layout.activity_shouye;
    }


    @Override
    public boolean isUseTitleBar() {
        return false;
    }

    @Override
    public void initView() {
        mRg = (RadioGroup) findViewById(R.id.rg);
        mBarHome = (RadioButton) findViewById(R.id.bar_home);
        mBarCar = (RadioButton) findViewById(R.id.bar_car);
        mBarFind = (RadioButton) findViewById(R.id.bar_find);


        SharedPreferences pref = getSharedPreferences(ConstKey.KEY_WIFI_REMIND_Shared_Preference,MODE_PRIVATE);
        userName = pref.getString(ConstKey.KEY_SAVE_USER_NAME, "");

        homeFragment = new HomeFragment();
        carFragment = new CarFragment();
        findFragment = new FindFragment();

        lists = new ArrayList<>();
    }

    @Override
    public void initData() {
        lists.add(homeFragment);
        lists.add(carFragment);
        lists.add(findFragment);

        mRg.setOnCheckedChangeListener(this);
        mBarHome.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        BaseFragment baseFragment = null;
        switch (i) {
            case R.id.bar_home:
                baseFragment = homeFragment;
                break;
            case R.id.bar_car:
                baseFragment = carFragment;
                break;
            case R.id.bar_find:
                baseFragment = findFragment;
                break;
        }

        changeFragment(baseFragment);

    }
    public void changeFragment(BaseFragment baseFragment) {

        if (!baseFragment.isAdded()) {
            addFragment(R.id.fl, baseFragment);
        }

        for (BaseFragment fragment : lists) {
            if (fragment != baseFragment) {
                hideFragment(fragment);
            }
        }
        showFragment(baseFragment);
    }
}
