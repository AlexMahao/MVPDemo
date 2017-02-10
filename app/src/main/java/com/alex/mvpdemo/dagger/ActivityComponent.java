package com.alex.mvpdemo.dagger;



import com.alex.mvpdemo.activity.LoginActivity;

import dagger.Component;

/**
 * Created by alex_mahao on 2016/8/3.
 */
@PerActivity
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);
}
