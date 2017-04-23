package com.tanner.repo.ui.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Bundle;

import com.tanner.repo.domain.entity.Story;
import com.tanner.repo.ui.activity.StoryActivity;
import com.tanner.repo.ui.model.StoryModel;

import javax.inject.Inject;

import rx.Subscription;

public class StoryViewModel extends BaseObservable {

    private StoryModel storyModel;

    @Bindable
    public Story story;

    public String title = "";

    private Subscription subscription;

    @Inject
    public StoryViewModel(StoryModel storyMode) {
        this.storyModel = storyMode;
    }

    public void onDestroy() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void pushArguments(Bundle bundle) {
        Story story = bundle.getParcelable(StoryActivity.ARG_STORY);
        if (story != null) {
            setTitle(story.getTitle());
            getStory(story.id);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        if (story == null) return "";

        return story.getImage();
    }

    public String getBody() {
        return storyModel.getBody(story);
    }

    public void setStory(Story story) {
        this.story = story;
        this.title = story.getTitle();
        notifyChange();
    }

    public Story getStory() {
        return story;
    }

    public void getStory(int id) {
        subscription = storyModel.getStory(id, story1 -> setStory(story1));
    }

}
