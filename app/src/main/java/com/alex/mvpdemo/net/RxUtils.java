package com.alex.mvpdemo.net;

import com.alex.mvpdemo.model.Result;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 对 RxJava 进行封装，实现异步调用
 * Created by alex_mahao on 2016/9/2.
 */
public class RxUtils {

    /**
     * RxJava 封装网络请求
     *
     */
    public static  void request(final Map<String,String> params, Subscriber<Result> subscriber,List<Subscription> list) {

        Subscription subscribe = Observable.create(new Observable.OnSubscribe<Result>() {
            @Override
            public void call(Subscriber<? super Result> subscriber) {

                try {

                    // 正常的网络请求，返回result,将result 回传
                    Result result = new Result("1", "成功", "");
                    subscriber.onNext(result);
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

        list.add(subscribe);

    }

}
