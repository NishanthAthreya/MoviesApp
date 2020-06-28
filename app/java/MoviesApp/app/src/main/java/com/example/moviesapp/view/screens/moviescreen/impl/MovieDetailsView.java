package com.example.moviesapp.view.screens.moviescreen.impl;

import com.example.moviesapp.databinding.FragmentMovieBinding;
import com.example.moviesapp.view.BaseViewImpl;
import com.example.moviesapp.view.screens.moviescreen.model.MovieScreenDetails;

public class MovieDetailsView extends BaseViewImpl<FragmentMovieBinding> {

    private final MovieScreenDetails movieScreenDetails;

    MovieDetailsView(MovieScreenDetails movieScreenDetails) {
        this.movieScreenDetails = movieScreenDetails;
    }

    @Override
    protected void setBinding(FragmentMovieBinding binding) {
        binding.setViewModel(new MovieDetailsViewModel(movieScreenDetails));
    }

    @Override
    protected void clearBinding() {

    }
}
