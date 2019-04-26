package com.fingerbeat.cloud.base.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fingerbeat.cloud.BaseFragment;

/**
 * 作者：XieCaibao
 * 时间： 2019/4/26
 * 邮箱：825302814@qq.com
 */
public abstract class BaseMvpFragment<P extends BasePresenter> extends BaseFragment implements IView {
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (null != mPresenter) {
            mPresenter.attachView(this);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }


    protected abstract P createPresenter();

    protected void showLoading() {
    }

    protected void hideLoading() {

    }
}
