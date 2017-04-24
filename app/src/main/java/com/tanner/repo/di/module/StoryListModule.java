package com.tanner.repo.di.module;

import android.content.Context;

import com.tanner.repo.ui.model.StoryListModel;
import com.tanner.repo.ui.viewmodel.StoryListViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class StoryListModule {

    private Context context;

    public StoryListModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    StoryListViewModel provideViewModel() {
        return new StoryListViewModel(context, new StoryListModel(context));
    }

    @Provides
    Context provideContext() {
        return context;
    }

}
