package com.tanner.repo.domain.service;


import com.tanner.repo.domain.entity.Story;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface StoryService {

    @GET("story/{story_id}")
    Observable<Story> getStory(@Path("story_id") int storyId);

}
