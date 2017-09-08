package com.example.carman.base;

import android.content.SharedPreferences;

import com.example.carman.R;
import com.example.carman.db.ConstKey;
import com.example.carman.db.DBSheQuBeanUtils;
import com.example.library.base.BaseApp;
import com.example.library.base.TitleBarConfig;

/**
 * Created by Administrator on 2017/5/9.
 */

public class CarBaseApp extends BaseApp {
    @Override
    public void initTitleBar() {
        TitleBarConfig.isUserTitleBar = true;
        TitleBarConfig.titleBarId = R.layout.titlebar;
        //用SharedPreferences 存储用户名
        SharedPreferences pref = getApplicationContext().getSharedPreferences(ConstKey.KEY_WIFI_REMIND_Shared_Preference,MODE_PRIVATE);
        editor = pref.edit();
        DBSheQuBeanUtils.Init(getApplicationContext());
    }
}
