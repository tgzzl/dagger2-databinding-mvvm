package com.tanner.repo.domain.service;


import com.tanner.repo.domain.entity.Daily;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface DailyService {

    @GET("news/latest")
    Observable<Daily> getLatest();

    @GET("stories/before/{datetime}?client=0")
    Observable<Daily> getBefore(@Path("datetime") int datetime);

}
