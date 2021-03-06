package com.fingerbeat.cloud.net.download;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class JsDownloadInterceptor implements Interceptor {
    private DownloadListener downloadListener;
    public JsDownloadInterceptor(DownloadListener downloadListener) {
        this.downloadListener = downloadListener;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response.newBuilder().body(
                new JsResponseBody(response.body(), downloadListener)).build();
    }
}