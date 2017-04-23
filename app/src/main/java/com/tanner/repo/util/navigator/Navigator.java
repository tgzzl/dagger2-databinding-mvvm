package com.tanner.repo.util.navigator;

import android.content.Context;
import android.os.Bundle;

import com.tanner.repo.domain.entity.Story;
import com.tanner.repo.ui.activity.StoryActivity;


public class Navigator extends BaseNavigator {

    private static Navigator instance = new Navigator();

    private Navigator() {
    }

    public static Navigator getInstance() {
        return instance;
    }

    public void openStory(Context context, Story story) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(StoryActivity.ARG_STORY, story);
        start(context, StoryActivity.class, bundle);
    }

}
