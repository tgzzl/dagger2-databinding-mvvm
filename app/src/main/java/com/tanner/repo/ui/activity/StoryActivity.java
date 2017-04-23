package com.tanner.repo.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.tanner.repo.R;
import com.tanner.repo.databinding.ActivityStoryBinding;
import com.tanner.repo.di.component.DaggerStoryComponent;
import com.tanner.repo.di.module.StoryModule;
import com.tanner.repo.ui.viewmodel.StoryViewModel;

import javax.inject.Inject;

public class StoryActivity extends BaseActivity {

    public static final String ARG_STORY = "ARG_STORY";

    @Inject
    StoryViewModel viewModel;

    private ActivityStoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (viewModel != null) {
            viewModel.onDestroy();
        }
    }

    @Override
    public void onCreateBinding() {
        DaggerStoryComponent.builder()
                .storyModule(new StoryModule(this))
                .build()
                .inject(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_story);
        binding.setStoryViewModel(viewModel);
        viewModel.pushArguments(getIntent().getExtras());
    }

    private void initViews() {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
