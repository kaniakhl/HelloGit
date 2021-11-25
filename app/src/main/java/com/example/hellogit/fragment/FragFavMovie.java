package com.example.hellogit.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellogit.R;
import com.example.hellogit.activities.DetailActivity;
import com.example.hellogit.adapter.MovieAdapt;
import com.example.hellogit.ModelMovie;
import com.example.hellogit.RealmDB;

import java.util.ArrayList;
import java.util.List;

public class FragFavMovie extends Fragment implements MovieAdapt.onSelectData {

    private RecyclerView rvMovieFav;
    private List<ModelMovie> modelMovie = new ArrayList<>();
    private RealmDB helper;
    private TextView txtNoData;

    public FragFavMovie() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorite_film, container, false);

        helper = new RealmDB(getActivity());

        txtNoData = rootView.findViewById(R.id.tvNotFound);
        rvMovieFav = rootView.findViewById(R.id.rvMovieFav);
        rvMovieFav.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMovieFav.setAdapter(new MovieAdapt(getActivity(), modelMovie, this));
        rvMovieFav.setHasFixedSize(true);

        setData();

        return rootView;
    }

    private void setData() {
        modelMovie = helper.showFavoriteMovie();
        if (modelMovie.size() == 0) {
            txtNoData.setVisibility(View.VISIBLE);
            rvMovieFav.setVisibility(View.GONE);
        } else {
            txtNoData.setVisibility(View.GONE);
            rvMovieFav.setVisibility(View.VISIBLE);
            rvMovieFav.setAdapter(new MovieAdapt(getActivity(), modelMovie, this));
        }
    }

    @Override
    public void onSelected(ModelMovie modelMovie) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("detailMovie", modelMovie);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        setData();
    }
}
