package com.tanner.repo.ui.model;

import android.content.Context;

import com.tanner.repo.MyApplication;
import com.tanner.repo.domain.entity.BaseEntity;
import com.tanner.repo.domain.entity.Daily;
import com.tanner.repo.domain.entity.StorySection;
import com.tanner.repo.domain.service.DailyService;
import com.tanner.repo.domain.service.StoryService;
import com.tanner.repo.ui.view.StoryListView;
import com.tanner.repo.ui.view.RequestView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class StoryListModel {

    private int lastDatetime = 0;
    private List<BaseEntity> data = new ArrayList<>();

    @Inject
    DailyService dailyService;

    @Inject
    StoryService storyService;

    @Inject
    public StoryListModel(Context context) {
        MyApplication.from(context).getAppComponent().inject(this);
    }

    private StoryListView view;
    private RequestView requestView;

    public void setView(StoryListView view, RequestView<BaseEntity> requestView) {
        this.view = view;
        this.requestView = requestView;
    }

    public void getDaily() {
        getDaily(lastDatetime);
    }

    private StorySection section;

    @DebugLog
    public void getDaily(final int datetime) {
        Timber.d("getDaily %d", datetime);
        Observable<Daily> observable = datetime > 0 ? dailyService.getBefore(datetime) : dailyService.getLatest();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Daily>() {
                    @Override
                    public void onCompleted() {
                        requestView.onRequestFinished();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "onError");
                    }

                    @Override
                    public void onNext(Daily daily) {
                        if (daily != null) {
                            lastDatetime = Integer.parseInt(daily.getDate());
                            data.clear();

                            if (datetime == 0) {
                                view.bindTopStories(daily.getTop_stories());
                            } else {
                                section = new StorySection(daily.getDate());
                                data.add(section);
                            }

                            data.addAll(daily.getStories());
                            requestView.onRequestSuccess(data);
                        }
                    }
                });
    }

}
