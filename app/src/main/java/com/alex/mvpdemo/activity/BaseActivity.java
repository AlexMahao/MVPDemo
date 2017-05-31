package com.alex.mvpdemo.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alex.mvpdemo.App;
import com.alex.mvpdemo.dagger.ActivityComponent;
import com.alex.mvpdemo.dagger.ActivityModule;
import com.alex.mvpdemo.dagger.DaggerActivityComponent;
import com.alex.mvpdemo.presenter.IPresenter;
import com.alex.mvpdemo.util.AppManager;
import com.alex.mvpdemo.view.IView;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by alex_mahao on 2016/8/3.
 */
public abstract class BaseActivity<T extends IPresenter> extends AppCompatActivity implements IView {

    @Inject
    public T presenter; // presenter对象

    @Inject
    protected Dialog dialog; // 每一个activity中都需要一个dialog的实例

    @Inject
    protected App app; // 上下文对象

    private ActivityComponent dagger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 动画切换
        // overridePendingTransition(R.anim.fade_in, R.anim.fade_out1);

        super.onCreate(savedInstanceState);

        // 竖屏锁定
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏

        // 全屏的回调函数
        setScreenStatus();

        // 设置布局
        setContentView(getLayoutId());

        // 添加到堆栈管理
        AppManager.getAppManager().addActivity(this);

        // 依赖注入
        dagger = DaggerActivityComponent.builder()
                .appComponent(App.sAppComponent)
                .activityModule(new ActivityModule(this))
                .build();

        inject(dagger);

        // 绑定presenter 对象
        presenter.attachView(this);

        // 查找控件额类
        ButterKnife.bind(this);

        // 子类回调初始化
        afterCreate();
    }

    /**
     * 设置屏幕状态
     */
    public void setScreenStatus() {}

    /**
     * 初始化一些配置
     */
    protected abstract void afterCreate();

    protected abstract void inject(ActivityComponent dagger);

    public abstract int getLayoutId();

    @Override
    public void showLoading(String msg) {
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        //Tt.showShort(msg);
        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public App getApp() {
        return app;
    }

    /**
     * 获取注入对象
     */
    public ActivityComponent getDagger() {
        return dagger;
    }

    @Override
    public void intent2Activity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    @Override
    public void intent2Activity(Class cls, Bundle budle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(budle);
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
        // 动画特效
        // overridePendingTransition(0, R.anim.fade_out);
    }

    @Override
    public void intentActivityForResult(Class cls, Bundle bundle, int requestData) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivityForResult(intent, requestData);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deteachView();
        presenter = null;
        AppManager.getAppManager().finishActivity(this);
    }
}
