package com.fingerbeat.cloud.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fingerbeat.cloud.BaseActivity;

/**
 * 作者：XieCaibao
 * 时间： 2019/4/25
 * 邮箱：825302814@qq.com
 */
public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements IView{
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (null != mPresenter) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract P createPresenter();

    protected void showLoading() {
    }

    protected void hideLoading() {

    }
}
