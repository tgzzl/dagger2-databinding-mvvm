package com.tanner.repo.ui.viewmodel;

import android.content.Context;
import android.view.View;

import com.liuguangqiang.support.utils.IntentUtils;
import com.liuguangqiang.support.widgets.recyclerview.OnPageListener;
import com.liuguangqiang.support.widgets.recyclerview.adapter.AbsRVAdapter;
import com.tanner.repo.R;
import com.tanner.repo.domain.entity.BaseEntity;
import com.tanner.repo.domain.entity.Story;
import com.tanner.repo.ui.adapter.StoryAdapter;
import com.tanner.repo.ui.model.MainModel;
import com.tanner.repo.ui.view.MainView;
import com.tanner.repo.ui.view.RequestView;
import com.tanner.repo.util.events.TopStoriesEvent;
import com.tanner.repo.util.navigator.Navigator;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

public class MainViewModel extends AbsRecyclerViewModel<BaseEntity>
        implements MainView, RequestView<BaseEntity>, AbsRVAdapter.OnItemClickListener {

    private Context context;

    private MainModel mainModel;

    private StoryAdapter adapter;

    @Inject
    public MainViewModel(Context context, MainModel mainModel) {
        this.context = context;
        this.mainModel = mainModel;
        mainModel.setView(this, this);

        adapter = new StoryAdapter(context, getData());
        adapter.setOnItemClickListener(this);

        requestData();
    }

    public StoryAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void onItemClick(View view, int position) {
        BaseEntity entity = data.get(position);
        if (entity instanceof Story) {
            Navigator.getInstance().openStory(context, (Story) entity);
        }
    }

    @Override
    public void requestData() {
        super.requestData();
        mainModel.getDaily();
    }

    @Override
    public void bindTopStories(List<Story> stories) {
        TopStoriesEvent event = new TopStoriesEvent(stories);
        EventBus.getDefault().post(event);
    }

    public OnPageListener getOnPageListener() {
        return () -> requestData();
    }

}
