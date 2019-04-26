package com.fingerbeat.cloud.base.mvp.sample;

import android.widget.EditText;

import com.fingerbeat.cloud.R;
import com.fingerbeat.cloud.base.mvp.BaseMvpActivity;


/**
 * 作者：XieCaibao
 * 时间： 2019/4/25
 * 邮箱：825302814@qq.com
 */
public class TestLoginActivity extends BaseMvpActivity<TestLoginPresenter> implements ILoginView {
    @Override
    protected int getLayoutResource() {
        return R.layout.sample_activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
        EditText etPhone = findViewById(R.id.et_phone);
        EditText etVerifyCode = findViewById(R.id.et_verify_code);
        findViewById(R.id.tv_login).setOnClickListener(v -> mPresenter.login(etPhone.getText().toString(), etVerifyCode.getText().toString()));
    }

    @Override
    protected TestLoginPresenter createPresenter() {
        return new TestLoginPresenter();
    }


    @Override
    public void loginSuccess() {
        toast("login success");
    }

    @Override
    public void loginFailed() {
        toast("loginFailed");
    }
}
