package com.tanner.repo.ui.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.tanner.repo.ui.activity.StoryListActivity;
import com.tanner.repo.util.navigator.Navigator;

import javax.inject.Inject;

public class MainViewModel extends BaseObservable {

    @Inject
    public MainViewModel() {

    }

    public View.OnClickListener getFabClickListener() {
        return v -> Navigator.getInstance().start(v.getContext(), StoryListActivity.class);
    }

}
