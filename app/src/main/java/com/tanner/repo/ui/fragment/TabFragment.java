package com.tanner.repo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tanner.repo.databinding.FragmentTabBinding;
import com.tanner.repo.ui.model.TabFragmentModel;
import com.tanner.repo.ui.viewmodel.TabFragmentViewModel;


public class TabFragment extends Fragment {

    public static final String ARG_STORY = "ARG_STORY";

    private String text;


    public static TabFragment newInstance(String text) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_STORY, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(ARG_STORY)) {
            text = bundle.getString(ARG_STORY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTabBinding binding = FragmentTabBinding.inflate(inflater);
        binding.setViewModel(new TabFragmentViewModel(getContext(), new TabFragmentModel(getContext(), text)));
        return binding.getRoot();

    }

}
