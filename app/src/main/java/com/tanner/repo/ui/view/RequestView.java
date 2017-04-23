package com.tanner.repo.ui.view;


import java.util.List;

public interface RequestView<T> {

    void onRequestFinished();

    void onRequestSuccess(List<T> list);

}
