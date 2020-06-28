package com.example.moviesapp.view.screens.moviescreen.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.moviesapp.databinding.FragmentMovieBinding;
import com.example.moviesapp.view.BaseFragment;
import com.example.moviesapp.view.ScreenView;
import com.example.moviesapp.view.screens.moviescreen.model.MovieScreenDetails;

public class MovieDetailsScreenFragment extends BaseFragment<FragmentMovieBinding> {

    @Override
    protected FragmentMovieBinding binding(LayoutInflater inflater, ViewGroup container) {
        return FragmentMovieBinding.inflate(
                inflater,
                container,
                false
        );
    }

    @Override
    protected ScreenView<FragmentMovieBinding> view() {
        return new MovieDetailsView(new MovieScreenDetails(getArguments().getString("id")));
    }
}
