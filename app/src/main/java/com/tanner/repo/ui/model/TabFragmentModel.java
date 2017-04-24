package com.tanner.repo.ui.model;

import android.content.Context;

import com.tanner.repo.MyApplication;
import com.tanner.repo.domain.entity.BaseEntity;
import com.tanner.repo.domain.entity.Daily;
import com.tanner.repo.domain.entity.StorySection;
import com.tanner.repo.domain.service.DailyService;
import com.tanner.repo.domain.service.StoryService;
import com.tanner.repo.ui.view.RequestView;
import com.tanner.repo.ui.view.StoryListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class TabFragmentModel {
    public String text;

    public TabFragmentModel(Context context, String text) {
        this.text = text;
    }

}
