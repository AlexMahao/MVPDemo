package com.alex.mvpdemo.dagger;


import com.alex.mvpdemo.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alex_mahao on 2016/8/3.
 */
@Module
public class AppModule {

    private App app;

    public AppModule(App app){
        this.app = app;
    }

    @Singleton
    @Provides
    App provideContext(){
        return app;
    }

   /* @Singleton
    @Provides
    SPUtils provideSPUtils(){
        return new SPUtils(app.getApplication(),"sss");
    }*/
}
