package com.tanner.repo.ui.viewmodel;

import android.databinding.BaseObservable;
import android.view.View;

import com.tanner.repo.domain.entity.Story;
import com.tanner.repo.util.navigator.Navigator;


public class TopStoryViewModel extends BaseObservable {

    private Story story;

    public void setStory(Story s) {
        this.story = s;
    }

    public View.OnClickListener getPicClickListener() {
        return v -> Navigator.getInstance().openStory(v.getContext(), story);
    }

    public String getImage() {
        if (story == null) return "";

        return story.getImage();
    }

}
