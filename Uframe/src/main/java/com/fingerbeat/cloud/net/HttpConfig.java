package com.fingerbeat.cloud.net;

/**
 * Created by xiecaibao on 2018/9/13
 */
public class HttpConfig {
    //商用环境
    private static final String BASE_URL = "http://47.105.81.154:8023";
    //测试环境
//    private static final String BASE_URL = "http://192.168.0.104:8020";

//    private static String CHAT_SERVER_URL = "https://socket-io-chat.now.sh/";
    private static String mUrl = BASE_URL;
    private static String mPwd = "";
    private static String mIv = "";

    public static String getUrl() {
        return mUrl;
    }

    public static void setUrl(String url) {
        HttpConfig.mUrl = url;
    }

    public static String getPwd() {
        return mPwd;
    }

    public static void setPwd(String pwd) {
        HttpConfig.mPwd = pwd;
    }

    public static String getIv() {
        return mIv;
    }

    public static void setIv(String iv) {
        HttpConfig.mIv = iv;
    }
}
