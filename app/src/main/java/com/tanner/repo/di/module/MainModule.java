package com.tanner.repo.di.module;

import android.content.Context;

import com.tanner.repo.ui.model.MainModel;
import com.tanner.repo.ui.viewmodel.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private Context context;

    public MainModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    MainViewModel provideViewModel() {
        return new MainViewModel(context, new MainModel(context));
    }

    @Provides
    Context provideContext() {
        return context;
    }

}
