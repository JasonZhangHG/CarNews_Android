package com.example.library.base;

import android.app.Application;
import android.content.SharedPreferences;
import org.xutils.x;

/**
 * Created by admin on 2017/4/28.
 * <p>
 * 做初始化操作.
 */

public abstract class BaseApp extends Application {

    public static SharedPreferences.Editor editor;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
        initTitleBar();


    }

    //  做 titleBar的初始化 工作
    public abstract void initTitleBar();

}
