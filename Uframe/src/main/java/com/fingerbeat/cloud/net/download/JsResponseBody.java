package com.fingerbeat.cloud.net.download;


import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * Created by xiecaibao on 2018/9/14
 */
public class JsResponseBody extends ResponseBody {
    private ResponseBody responseBody;
    private DownloadListener downloadListener;
    // BufferedSource 是okio库中的输入流，这里就当作inputStream来使用。
    private BufferedSource bufferedSource;
    public JsResponseBody(ResponseBody responseBody, DownloadListener downloadListener) {
        this.responseBody = responseBody;
        this.downloadListener = downloadListener;
    }
    @Override
    public MediaType contentType() {
        return responseBody.contentType();
    }
    @Override
    public long contentLength() {
        return responseBody.contentLength();
    }
    @Override
    public BufferedSource source() {
        if (bufferedSource == null) {
            bufferedSource = Okio.buffer(source(responseBody.source()));
        }
        return bufferedSource;
    }
    private Source source(Source source) {
        return new ForwardingSource(source) {
            long totalBytesRead = 0L;
            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                totalBytesRead += bytesRead != -1 ? bytesRead : 0;
//                Log.e("download", "read: "+ (int) (totalBytesRead * 100 / responseBody.contentLength()));
                if (null != downloadListener) {
                    if (bytesRead != -1) {
                        downloadListener.onProgress(responseBody.contentLength(), totalBytesRead);
                    }
                }
                return bytesRead;
            }
        };
    }
}
