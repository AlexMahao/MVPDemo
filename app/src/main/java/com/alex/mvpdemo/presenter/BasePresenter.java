package com.alex.mvpdemo.presenter;

import com.alex.mvpdemo.view.IView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by alex_mahao on 2016/8/3.
 */
public class BasePresenter<T extends IView> implements IPresenter<T> {

    protected T view ;

    protected List<Subscription> mSubscriptionList = new ArrayList<>();

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void deteachView() {
        //取消线程订阅
        for(Subscription sub : mSubscriptionList){
            if(!sub.isUnsubscribed()){
                sub.unsubscribe();
            }
        }
        view = null;
    }
}
