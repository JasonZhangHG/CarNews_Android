package com.example.library.net;

/**
 * Created by admin on 2017/4/28.
 */

public interface NetCallBack<T> {

    public abstract void netOk(T t);

    public abstract void netError();

    public abstract void netfinish();


}
