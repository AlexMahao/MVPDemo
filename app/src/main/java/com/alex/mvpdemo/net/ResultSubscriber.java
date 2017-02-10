package com.alex.mvpdemo.net;


import rx.Subscriber;

/**
 * Created by mdw on 2016/4/20.
 */
public class ResultSubscriber<T> extends Subscriber<T> {


    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();

        //
        //Toast.makeText(ResultSubscriber.this, "程序出问题了", Toast.LENGTH_SHORT).show();

    }

    @Override
    public  void onNext(T o) {

    }
}
