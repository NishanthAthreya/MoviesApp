package com.example.moviesapp.view.screens.componentslist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.moviesapp.data.movies.model.Movie;
import com.example.moviesapp.databinding.FragmentComponentsListBinding;
import com.example.moviesapp.navigation.NavigationFragment;
import com.example.moviesapp.view.ScreenView;
import com.example.moviesapp.view.screens.moviescreen.impl.MovieDetailsScreenFragment;

/**
 * Components fragment.
 */
public class ComponentsFragment extends NavigationFragment<FragmentComponentsListBinding> {
    @Override
    protected FragmentComponentsListBinding binding(LayoutInflater inflater, ViewGroup container) {
        return FragmentComponentsListBinding.inflate(
                inflater,
                container,
                false
        );
    }

    class ComponentsNavigator {

        void openMovieDetails(Movie movie) {
            Bundle bundle = new Bundle();
            bundle.putString("id", movie.getId());
            MovieDetailsScreenFragment movieDetailsScreenFragment = new MovieDetailsScreenFragment();
            navigateTo(
                    bundle,
                    movieDetailsScreenFragment
            );
        }
    }

    @Override
    protected ScreenView<FragmentComponentsListBinding> view() {
        return new ComponentsView(new ComponentsNavigator());
    }
}
