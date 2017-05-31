package com.alex.mvpdemo.activity;

import android.widget.EditText;

import com.alex.mvpdemo.R;
import com.alex.mvpdemo.dagger.ActivityComponent;
import com.alex.mvpdemo.presenter.LoginPresenter;
import com.alex.mvpdemo.view.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by alex_mahao on 2017/2/10.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.username_et)
    EditText username_et;

    @OnClick(R.id.login_tv)
    public void login() {
        presenter.login();
    }

    @Override
    protected void afterCreate() {
        // 初始化操作
    }

    @Override
    protected void inject(ActivityComponent dagger) {
        dagger.inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public String getUsername() {
        return username_et.getText().toString().trim();
    }
}
