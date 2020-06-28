package com.example.moviesapp.view.screens.moviescreen.impl

import com.example.moviesapp.databinding.FragmentMovieBinding
import com.example.moviesapp.view.BaseViewImpl
import com.example.moviesapp.view.screens.moviescreen.model.MovieScreenDetails

internal class MovieDetailsView(private val movieScreenDetails: MovieScreenDetails):
        BaseViewImpl<FragmentMovieBinding>() {
    override fun setBinding(binding: FragmentMovieBinding) {
        binding.viewModel = MovieDetailsViewModel(movieScreenDetails)
    }

    override fun clearBinding() {}
}