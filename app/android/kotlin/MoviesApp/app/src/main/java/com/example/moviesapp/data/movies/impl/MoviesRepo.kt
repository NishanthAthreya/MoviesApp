package com.example.moviesapp.data.movies.impl

import com.example.moviesapp.data.movies.MoviesApi
import com.example.moviesapp.data.movies.model.Movie
import com.example.moviesapp.data.util.retrofit.RetrofitFactory
import io.reactivex.Observable

/**
 * Repo that provides list of movies.
 */
internal class MoviesRepo {

    private val api: MoviesApi = RetrofitFactory()
            .build()
            .create(MoviesApi::class.java)
    private val converter: MoviesDtoConverter = MoviesDtoConverter()

    /**
     * Returns list of movies.
     */
    fun movies(): Observable<List<Movie>> {
        return api.movies().map {
            converter(it)
        }.toObservable()
    }

    /**
     * Returns movie.
     *
     * @param id id of movie
     */
    fun movie(id: String): Observable<Movie> {
        return api.movies().map {
            converter(it)
        }.map{
            it.first{ movie ->
                movie.id == id
            }
        }.toObservable()
    }
}