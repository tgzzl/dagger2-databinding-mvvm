package com.tanner.repo.di.component;


import com.tanner.repo.di.module.MainModule;
import com.tanner.repo.ui.activity.StoryListActivity;

import dagger.Component;

@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(StoryListActivity activity);

}
