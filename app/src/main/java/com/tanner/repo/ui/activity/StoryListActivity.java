package com.tanner.repo.ui.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.liuguangqiang.support.widgets.DividerItemDecoration;
import com.tanner.repo.R;
import com.tanner.repo.databinding.ActivityStoryListBinding;
import com.tanner.repo.di.component.DaggerStoryListComponent;
import com.tanner.repo.di.module.StoryListModule;
import com.tanner.repo.domain.entity.Story;
import com.tanner.repo.ui.adapter.TopStoryAdapter;
import com.tanner.repo.ui.viewmodel.StoryListViewModel;
import com.tanner.repo.util.events.TopStoriesEvent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class StoryListActivity extends BaseActivity {

    CollapsingToolbarLayout collapsingToolbar;

    private TopStoryAdapter topStoryAdapter;
    private List<Story> topStories = new ArrayList<>();

    @Inject
    StoryListViewModel storyListViewModel;

    ActivityStoryListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar();
        initViews();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onCreateBinding() {
        DaggerStoryListComponent
                .builder()
                .storyListModule(new StoryListModule(this))
                .build().inject(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_story_list);
        binding.setViewModel(storyListViewModel);
    }

    private void initToolbar() {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbar = binding.collapsingToolbar;
        collapsingToolbar.setTitle(getString(R.string.app_name));
        collapsingToolbar.setExpandedTitleColor(Color.WHITE);
        collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
    }

    private void initViews() {
        binding.rvNews.addItemDecoration(new DividerItemDecoration(this, android.R.drawable.divider_horizontal_textfield));

        topStoryAdapter = new TopStoryAdapter(getSupportFragmentManager(), topStories);

        binding.viewPager.setAdapter(topStoryAdapter);
        binding.indicator.setViewPager(binding.viewPager);
        binding.indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                collapsingToolbar.setTitle(topStories.get(position).getTitle());
                setTitle(topStories.get(position).getTitle());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Subscribe
    public void onEvent(TopStoriesEvent event) {
        if (event.stories != null) {
            topStories.addAll(event.stories);
            topStoryAdapter.notifyDataSetChanged();
            collapsingToolbar.setTitle(topStories.get(0).getTitle());
        }
    }

}
