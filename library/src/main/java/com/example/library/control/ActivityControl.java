package com.example.library.control;

import com.example.library.base.BaseActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 使用这个类来模拟 activity 回退栈的效果
 */

public class ActivityControl {

    public static List<BaseActivity> lists = new ArrayList<>();

    // 每当启动一个activity就 添加到 集合中
    public static void addActivity(BaseActivity baseActivity) {

        lists.add(baseActivity);

    }

    //每当销毁一个activity就 从集合中 移除
    public static void removeActivity(BaseActivity baseActivity) {

        lists.remove(baseActivity);
    }

    // 找到指定的activity实例(对象)
    public BaseActivity getActivity(Class clazz) {
        for (BaseActivity list : lists) {
            if (list.getClass() == clazz) {
                return list;
            }
        }
        return null;
    }

    public static void killAllActivity() {

        Iterator<BaseActivity> iterator = lists.iterator();

        while (iterator.hasNext()) {
            BaseActivity baseActivity = iterator.next();
            baseActivity.finish();
        }


    }

}
