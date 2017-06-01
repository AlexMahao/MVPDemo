package com.alex.mvpdemo;

import android.app.Application;

import com.alex.mvpdemo.dagger.AppComponent;
import com.alex.mvpdemo.dagger.AppModule;
import com.alex.mvpdemo.dagger.DaggerAppComponent;


/**
 * Application 实现类
 * Created by alex_mahao on 2016/8/3.
 */
public class App extends Application {

    public static AppComponent sAppComponent;

    public static App sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        initDagger();
    }

    private void initDagger() {
        sAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    /**
     * 获取全文的上下文对象
     */
    public static App getApp() {
        return sApp;
    }
}
