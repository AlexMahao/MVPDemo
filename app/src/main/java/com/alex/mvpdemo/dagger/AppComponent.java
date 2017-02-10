package com.alex.mvpdemo.dagger;


import com.alex.mvpdemo.App;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by alex_mahao on 2016/8/3.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    // 不提供注入方法，主要负责每一个Activity 的依赖
    void inject(App app);

    // 向依赖类提供对象
    App getApp();

   // SPUtils getSPUtils();
}
