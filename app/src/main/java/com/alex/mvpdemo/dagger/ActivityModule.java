package com.alex.mvpdemo.dagger;

import android.app.Activity;
import android.app.Dialog;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alex_mahao on 2016/8/3.
 */
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    Dialog provideDialog(){
        return new Dialog(activity);
    }
}
