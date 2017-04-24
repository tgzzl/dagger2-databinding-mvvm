package com.tanner.repo.ui.view;

import com.tanner.repo.domain.entity.Story;

import java.util.List;

public interface StoryListView {

    void bindTopStories(List<Story> stories);

}
