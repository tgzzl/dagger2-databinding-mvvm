package com.tanner.repo.di.component;


import com.tanner.repo.di.module.StoryListModule;
import com.tanner.repo.ui.activity.StoryListActivity;

import dagger.Component;

@Component(modules = StoryListModule.class)
public interface StoryListComponent {

    void inject(StoryListActivity activity);

}
