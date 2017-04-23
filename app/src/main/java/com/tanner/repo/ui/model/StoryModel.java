package com.tanner.repo.ui.model;

import android.content.Context;


import com.tanner.repo.MyApplication;
import com.tanner.repo.domain.entity.Story;
import com.tanner.repo.domain.service.StoryService;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class StoryModel {

    @Inject
    StoryService storyService;

    @Inject
    public StoryModel(Context context) {
        MyApplication.from(context).getAppComponent().inject(this);
    }

    public Subscription getStory(int id, Action1<Story> observer) {
        return storyService.getStory(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public String getBody(Story story) {
        if (story == null) return "";
        return loadDataWithCSS(story.getBody(), story.getCss().get(0));
    }

    private String loadDataWithCSS(String loadData, String cssPath) {
        String header = "<html><head><link href=\"%s\" type=\"text/css\" rel=\"stylesheet\"/></head><body>";
        String footer = "</body></html>";
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(header, cssPath));
        sb.append(loadData);
        sb.append(footer);
        return sb.toString();
    }

}
