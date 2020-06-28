package com.example.moviesapp.view.screens.componentslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.moviesapp.data.movies.model.Movie
import com.example.moviesapp.databinding.FragmentComponentsListBinding
import com.example.moviesapp.navigation.NavigationFragment
import com.example.moviesapp.view.screens.moviescreen.impl.MovieDetailsScreenFragment

/**
 * Components fragment.
 */
internal class ComponentsFragment: NavigationFragment<FragmentComponentsListBinding>() {

    private val componentsNavigator: (Movie) -> Unit =
        {
            val bundle = Bundle()
            bundle.putString("id", it.id)
            val movieDetailsScreenFragment = MovieDetailsScreenFragment()
            navigateTo(
                    bundle,
                    movieDetailsScreenFragment
            )
        }

    override fun binding(inflater: LayoutInflater, container: ViewGroup) =
            FragmentComponentsListBinding.inflate(
                    inflater,
                    container,
                    false
            )

    override fun view() = ComponentsView(componentsNavigator)
}