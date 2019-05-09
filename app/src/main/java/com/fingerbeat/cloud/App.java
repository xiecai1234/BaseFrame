package com.fingerbeat.cloud;

import com.fingerbeat.cloud.net.HttpConfig;

/**
 * 作者：XieCaibao
 * 时间： 2019/4/25
 * 邮箱：825302814@qq.com
 */
public class App extends BaseApplication{
    @Override
    public void onCreate() {
        super.onCreate();

        HttpConfig.setPwd("ABHUNUIOPKNHUMHBYTGFXZRETlopiuyh");
        HttpConfig.setIv("oiunyhgbsnkopliu");
    }
}
