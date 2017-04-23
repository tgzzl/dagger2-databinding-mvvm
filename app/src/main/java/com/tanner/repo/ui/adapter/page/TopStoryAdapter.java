package com.tanner.repo.ui.adapter.page;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.tanner.repo.domain.entity.Story;
import com.tanner.repo.ui.fragment.TopStoryFragment;

import java.util.ArrayList;
import java.util.List;

public class TopStoryAdapter extends FragmentStatePagerAdapter {

    public List<Story> stories = new ArrayList<>();

    public TopStoryAdapter(FragmentManager fragmentManager, List<Story> storyList) {
        super(fragmentManager);
        this.stories = storyList;
    }

    @Override
    public Fragment getItem(int position) {
        return TopStoryFragment.newInstance(stories.get(position));
    }

    @Override
    public int getCount() {
        return stories.size();
    }
}
