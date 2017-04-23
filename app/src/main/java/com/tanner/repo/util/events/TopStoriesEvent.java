package com.tanner.repo.util.events;

import com.tanner.repo.domain.entity.Story;

import java.util.List;

public class TopStoriesEvent {

    public List<Story> stories;

    public TopStoriesEvent(List<Story> stories) {
        this.stories = stories;
    }

}
