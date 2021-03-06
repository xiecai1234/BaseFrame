package com.fingerbeat.cloud.net;

import com.fingerbeat.cloud.net.bean.BaseBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by xiecaibao on 2018/9/6
 */
public interface HttpService {
    //版本检测
    @POST("api/download/apk")
    Flowable<Object> checkAppUpdateInfo();

    //登陆
    @POST("api/login")
    @Multipart
    Flowable<BaseBean> login(@Part("data") Map<String, String> body);
}
