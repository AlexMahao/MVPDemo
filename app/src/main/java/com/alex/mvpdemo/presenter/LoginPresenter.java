package com.alex.mvpdemo.presenter;

import android.text.TextUtils;

import com.alex.mvpdemo.model.Result;
import com.alex.mvpdemo.net.ResultSubscriber;
import com.alex.mvpdemo.net.RxUtils;
import com.alex.mvpdemo.view.LoginView;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by alex_mahao on 2017/2/10.
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    @Inject
    public LoginPresenter() {
    }


    /**
     * 登陆的逻辑
     */
    public void login() {

        String username = view.getUsername();

        if(TextUtils.isEmpty(username)){
            // 用户名为null
            view.showToast("请输入用户名");
            return;
        }

        Map<String, String> params = new HashMap<>();
        params.put("username",username);

        RxUtils.request(params,new ResultSubscriber<Result>(){
            @Override
            public void onNext(Result o) {
                if(o.getCode().equals("1")){
                    //登陆成功，跳转

                   // view.intent2Activity("XXXX".getClass());
                }else{
                    // 根据不同的code 处理
                }
            }
        },mSubscriptionList);

    }
}
