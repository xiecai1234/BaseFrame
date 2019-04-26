package com.fingerbeat.cloud.base.mvp.sample;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

import com.blankj.utilcode.util.AppUtils;
import com.fingerbeat.cloud.BaseApplication;
import com.fingerbeat.cloud.base.mvp.BasePresenter;
import com.fingerbeat.cloud.net.rx.RxSubscriber;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：XieCaibao
 * 时间： 2019/4/25
 * 邮箱：825302814@qq.com
 */
public class TestLoginPresenter extends BasePresenter<TestLoginActivity> {
    void login(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            toast("请填写用户名");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            toast("请填写密码");
            return;
        }
        if (!isViewAttached()) {
            return;
        }

        Map<String, String> map = new HashMap<>();
        String androidId = Settings.Secure.getString(BaseApplication.getAppContext().getContentResolver(), "android_id");
        int version = AppUtils.getAppVersionCode();
        map.put("androidId", androidId);
        map.put("channelName", "te01");
        map.put("remarkName", "test");
        map.put("version", String.valueOf(version));
        map.put("model", Build.MODEL);
        APIServiceImp.getInstance().login(map, new RxSubscriber<Object>(true) {
            @Override
            protected void _onNext(Object o) {
                getView().loginSuccess();
            }
        });
    }
}
