package com.example.hellogit.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.hellogit.R;
import com.example.hellogit.adapter.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class FragmentFavorite extends Fragment {

    public FragmentFavorite() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorite, container, false);

        ViewPager viewPager = rootView.findViewById(R.id.vpFavorite);
        viewPager.setAdapter(new ViewPageAdapter((getChildFragmentManager())));

        TabLayout tabLayout = rootView.findViewById(R.id.tabFavorite);
        tabLayout.setupWithViewPager(viewPager);

        (tabLayout.getTabAt(0)).setText("Movie");

        return rootView;
    }

}
