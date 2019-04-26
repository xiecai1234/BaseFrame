package com.fingerbeat.cloud.base.mvp.sample;

import com.fingerbeat.cloud.base.mvp.IView;

/**
 * 作者：XieCaibao
 * 时间： 2019/4/25
 * 邮箱：825302814@qq.com
 */
public interface ILoginView extends IView {
    void loginSuccess();
    void loginFailed();
}
