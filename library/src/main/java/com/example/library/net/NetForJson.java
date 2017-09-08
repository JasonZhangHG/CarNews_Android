package com.example.library.net;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 对 xutils 联网框架 进行 二次封装， 变成 符合 我们 商城 开发的框架
 */

public class NetForJson implements Callback.CommonCallback<String> {
    private final RequestParams requestParams;
    public String url;
    public Class clazz;
    public NetCallBack callBack;
    public boolean isPost;
    public Gson gson = new Gson();
    // get, post

    /**
     * post访问
     *
     * @param url
     * @param clazz
     * @param callBack
     * @param isPost   true 表示 post访问
     */
    public NetForJson(String url, Class clazz, NetCallBack callBack, boolean isPost) {
        this.url = url;
        this.clazz = clazz;
        this.callBack = callBack;
        this.isPost = isPost;
        // 将 url 传递到 xutils中
        requestParams = new RequestParams(url);
    }


    /**
     * get 访问
     *
     * @param url
     * @param clazz
     * @param callBack
     */
    public NetForJson(String url, Class clazz, NetCallBack callBack) {
        this(url, clazz, callBack, false);
    }


    // xutils 中 联网时的参数

    /**
     * 联网请求 添加 参数
     *
     * @param name
     * @param value
     */

    public void addParams(String name, Object value) {
        if (isPost) {
            requestParams.addBodyParameter(name, value + "");

        } else {
            requestParams.addParameter(name, value);
        }
    }

    public void doNet() {

        if (isPost) {
            x.http().post(requestParams, this);

        } else {
            x.http().get(requestParams, this);
        }


    }


    @Override
    public void onSuccess(String result) {
        // result : 联网成功后返回的 json 数据
        Object o = gson.fromJson(result, clazz);
        callBack.netOk(o);
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        ex.printStackTrace();
        callBack.netError();
    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {
        callBack.netfinish();
    }
}
