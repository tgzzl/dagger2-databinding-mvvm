package com.tanner.repo.di.module;

import android.content.Context;


import com.tanner.repo.ui.model.StoryModel;
import com.tanner.repo.ui.viewmodel.StoryViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class StoryModule {

    private Context context;

    public StoryModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    StoryViewModel provideViewModel() {
        return new StoryViewModel(new StoryModel(context));
    }

    @Provides
    Context provideContext() {
        return context;
    }
}
