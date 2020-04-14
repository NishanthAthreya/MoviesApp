package com.example.moviesapp.data.movies.impl;

import com.example.moviesapp.data.movies.dto.MoviesDto;
import com.example.moviesapp.data.movies.model.Movie;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Converter that converts the movies dto to a list of movies.
 */
public class MoviesDtoConverter implements Function<MoviesDto, List<Movie>> {

    @Override
    public List<Movie> apply(MoviesDto moviesDto) {
        return moviesDto.movies
                .movies
                .stream()
                .map(movieDto -> new Movie(
                        movieDto.title,
                        movieDto.id,
                        movieDto.imageUrl
                )).collect(Collectors.toList());
    }
}
