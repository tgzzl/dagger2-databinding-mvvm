package com.tanner.repo.di.component;

import com.tanner.repo.di.module.StoryModule;
import com.tanner.repo.ui.activity.StoryActivity;

import dagger.Component;

@Component(modules = StoryModule.class)
public interface StoryComponent {

    void inject(StoryActivity activity);

}
