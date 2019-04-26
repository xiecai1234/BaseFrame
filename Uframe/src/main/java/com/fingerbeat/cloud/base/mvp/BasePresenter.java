package com.fingerbeat.cloud.base.mvp;

import com.blankj.utilcode.util.ToastUtils;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

/**
 * 作者：XieCaibao
 * 时间： 2019/4/25
 * 邮箱：825302814@qq.com
 */
public abstract class BasePresenter<V extends IView> implements IPresenter<V> {
//    protected V mView;
    protected WeakReference<V> mViewRef;
    private final CompositeDisposable disposables = new CompositeDisposable();
    public BasePresenter(){
        //构造方法中不再需要View参数
    }

    /**
     * 绑定view，一般在初始化中调用该方法
     * @param view
     */
    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
//        this.mView= mvpView;
    }

    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView() {
//        this.mView= null;
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
        disposables.clear();
    }
    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached(){
        return mViewRef != null && mViewRef.get() != null;
    }

    public V getView() {
        return (V) mViewRef.get();
    }

    public void toast(String msg){
        ToastUtils.showShort(msg);
    }
}
