package com.example.moviesapp.data.movies.impl;

import com.example.moviesapp.data.movies.dto.MoviesListDto;
import com.example.moviesapp.data.movies.model.Movie;
import com.example.moviesapp.data.movies.model.MovieStatistics;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converter that converts the movies dto to a list of movies.
 */
public class MoviesDtoConverter implements Function<MoviesListDto, List<Movie>> {

    @Override
    public List<Movie> apply(MoviesListDto moviesDto) {
        return moviesDto.movies
                .stream()
                .map(movieDto -> new Movie(
                        movieDto.title,
                        movieDto.id,
                        movieDto.imageUrl,
                        movieDto.statistics != null ? new MovieStatistics(
                                movieDto.statistics.score,
                                movieDto.statistics.percentViewed
                        ) : new MovieStatistics(
                                null,
                                null
                        )
                )).collect(Collectors.toList());
    }
}
