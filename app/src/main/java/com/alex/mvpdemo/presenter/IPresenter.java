package com.alex.mvpdemo.presenter;


import com.alex.mvpdemo.view.IView;

/**
 * Presenter 的基类
 *
 * Created by alex_mahao on 2016/8/3.
 */
public interface IPresenter<T extends IView> {

    // 绑定View
    void attachView(T view);

    // 解绑View  防止内存溢出，及始终持有Activity
    void deteachView();

}
