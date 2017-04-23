package com.tanner.repo.di.component;

import com.tanner.repo.MyApplication;
import com.tanner.repo.di.module.AppModule;
import com.tanner.repo.ui.model.MainModel;
import com.tanner.repo.ui.model.StoryModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MyApplication application);

    void inject(StoryModel service);

    void inject(MainModel service);
}
