package com.alex.mvpdemo.view;

import android.os.Bundle;

import com.alex.mvpdemo.App;


/**
 *  View 的一些默认实现方法
 *
 * Created by alex_mahao on 2016/8/3.
 */
public interface IView {

    void showLoading(String msg);

    void hideLoading();

    void showToast(String msg);

    void intent2Activity(Class cls);

    App getApp();



    void finish();

    void intent2Activity(Class cls, Bundle bundle);


    void intentActivityForResult(Class cls, Bundle bundle, int requestData);
}
