package com.example.moviesapp.data.movies.impl

import com.example.moviesapp.data.movies.dto.MoviesListDto
import com.example.moviesapp.data.movies.model.Movie
import com.example.moviesapp.data.movies.model.MovieStatistics

/**
 * Converter that converts the movies dto to a list of movies.
 */
internal class MoviesDtoConverter: (MoviesListDto) -> List<Movie> {

    override fun invoke(input: MoviesListDto) = input.movies.map {
        with(it) {
            Movie(
                    title = title,
                    id = id,
                    imageUrl = imageUrl,
                    statistics = with(it.statistics) {
                        MovieStatistics(
                                score = score.toBigDecimal(),
                                percentViewed = percentViewed.toBigDecimal()
                        )
                    }
            )
        }
    }
}