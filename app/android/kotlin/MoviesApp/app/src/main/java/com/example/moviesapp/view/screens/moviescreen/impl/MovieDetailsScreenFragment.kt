package com.example.moviesapp.view.screens.moviescreen.impl

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.moviesapp.databinding.FragmentMovieBinding
import com.example.moviesapp.view.BaseFragment
import com.example.moviesapp.view.screens.moviescreen.model.MovieScreenDetails

internal class MovieDetailsScreenFragment: BaseFragment<FragmentMovieBinding>() {

    override fun binding(inflater: LayoutInflater, container: ViewGroup) =
            FragmentMovieBinding.inflate(
                    inflater,
                    container,
                    false
            )

    override fun view() = MovieDetailsView(
            movieScreenDetails = MovieScreenDetails(
                    arguments!!.getString("id")!!
            )
    )
}