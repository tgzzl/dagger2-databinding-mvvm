package com.tanner.repo;

import android.app.Application;
import android.content.Context;

import com.liuguangqiang.support.utils.Logs;
import com.tanner.repo.di.component.AppComponent;
import com.tanner.repo.di.component.DaggerAppComponent;
import com.tanner.repo.di.module.AppModule;

import hugo.weaving.DebugLog;
import timber.log.Timber;

public class MyApplication extends Application{
    private AppComponent appComponent;

    @DebugLog
    @Override
    public void onCreate() {
        super.onCreate();
        Logs.setIsDebug(BuildConfig.DEBUG);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Timber.tag("tanner");
        }

        appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static MyApplication from(Context context) {
        return (MyApplication) context.getApplicationContext();
    }
}
