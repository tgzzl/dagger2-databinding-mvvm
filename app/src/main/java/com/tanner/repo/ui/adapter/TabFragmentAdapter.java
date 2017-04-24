package com.tanner.repo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tanner.repo.ui.fragment.TabFragment;

public class TabFragmentAdapter extends FragmentPagerAdapter {
    static final String[] TITLES = {"笑话", "电影"};

    public TabFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.newInstance(TITLES[position]);
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
