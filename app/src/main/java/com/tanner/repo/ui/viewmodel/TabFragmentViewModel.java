package com.tanner.repo.ui.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.tanner.repo.domain.entity.Story;
import com.tanner.repo.ui.activity.StoryListActivity;
import com.tanner.repo.ui.model.TabFragmentModel;
import com.tanner.repo.util.navigator.Navigator;

import javax.inject.Inject;

public class TabFragmentViewModel extends BaseObservable {

    private Context context;

    private TabFragmentModel mainModel;

    @Bindable
    public String text;

    public TabFragmentViewModel(Context context, TabFragmentModel mainModel) {
        this.context = context;
        this.mainModel = mainModel;
        setText(mainModel.text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
