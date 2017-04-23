package com.tanner.repo.util.databinding;

import android.databinding.BindingAdapter;

import com.liuguangqiang.support.widgets.recyclerview.SuperRecyclerView;
import com.liuguangqiang.support.widgets.recyclerview.adapter.AbsRVAdapter;
import com.tanner.repo.R;
import com.tanner.repo.domain.entity.BaseEntity;

import java.util.List;

public class DBRecyclerView {

    public static int SHOW_FOOTER = 0;

    public static int HIDE_FOOTER = 1;

    @BindingAdapter({"adapter"})
    public static void bindAdapter(SuperRecyclerView recyclerView, AbsRVAdapter adapter) {
        recyclerView.setAdapter(adapter);
        recyclerView.setPageFooter(R.layout.layout_loading_footer);
    }

    @BindingAdapter({"data"})
    public static void bindData(SuperRecyclerView recyclerView, List<BaseEntity> data) {
        recyclerView.notifyDataSetChanged();
        recyclerView.setIsLoading(false);
    }

    @BindingAdapter({"isLoading"})
    public static void isLoading(SuperRecyclerView recyclerView, boolean isLoading) {
        recyclerView.setIsLoading(isLoading);
    }

    @BindingAdapter({"footerStatus"})
    public static void footerStatus(SuperRecyclerView recyclerView, int footerStatus) {
        if (footerStatus == SHOW_FOOTER) {
            recyclerView.setPageEnable(true);
            recyclerView.showLoadingFooter();
        } else {
            recyclerView.setPageEnable(false);
            recyclerView.removePageFooter();
        }
    }

}
