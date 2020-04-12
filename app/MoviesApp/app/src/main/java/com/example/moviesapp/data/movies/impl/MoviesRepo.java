package com.example.moviesapp.data.movies.impl;

import androidx.annotation.VisibleForTesting;

import com.example.moviesapp.data.movies.MoviesApi;
import com.example.moviesapp.data.movies.model.Movie;
import com.example.moviesapp.data.util.retrofit.RetrofitFactory;

import java.util.List;

import io.reactivex.Observable;

/**
 * Repo that provides list of movies.
 */
public class MoviesRepo {

    private final MoviesApi api;
    private final MoviesDtoConverter converter;

    public MoviesRepo() {
        this(
                new RetrofitFactory()
                        .build()
                        .create(MoviesApi.class),
                new MoviesDtoConverter()
        );
    }

    @VisibleForTesting
    MoviesRepo(MoviesApi api, MoviesDtoConverter converter) {
        this.api = api;
        this.converter = converter;
    }

    /**
     * Returns list of movies.
     */
    public Observable<List<Movie>> movies() {
        return api.movies()
                .map(converter::apply)
                .toObservable();
    }
}
