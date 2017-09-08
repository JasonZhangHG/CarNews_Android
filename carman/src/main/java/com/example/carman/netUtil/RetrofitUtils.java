package com.example.carman.netUtil;

import com.example.carman.entity.LoginBean;
import com.example.carman.entity.RegisterBean;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2017/5/14.
 */

public class RetrofitUtils {
    private static Retrofit retrofit;
    public static Retrofit getInstenct(){
         retrofit= new Retrofit.Builder()
                .baseUrl(Api.BASEUEL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public interface getNet{
        @FormUrlEncoded
        @POST("LoginServlet")
        Observable<LoginBean> Login(@Field("user_tel") String tel, @Field("user_pwd") String pwd);
    }
    public interface reigister{
        @FormUrlEncoded
        @POST("RegisterServlet")
        Observable<RegisterBean> register(@Field("userName") String tel, @Field("userPwd") String pwd);
    }


}
