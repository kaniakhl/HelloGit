package com.example.hellogit.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hellogit.fragment.FragFavMovie;

public class ViewPageAdapt extends FragmentPagerAdapter {

    private final Fragment[] tabFragments;

    public ViewPageAdapt(FragmentManager fragmentManager) {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabFragments = new Fragment[]{
                new FragFavMovie(),
        };
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return tabFragments[position];
    }

    @Override
    public int getCount() {
        return tabFragments.length;
    }
}
