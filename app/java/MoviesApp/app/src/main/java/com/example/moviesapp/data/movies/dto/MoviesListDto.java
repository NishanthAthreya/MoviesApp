package com.example.moviesapp.data.movies.dto;

import java.util.List;

/**
 * Movies list dto.
 */
public class MoviesListDto {

    public final List<MovieDto> movies;

    public MoviesListDto(List<MovieDto> movies) {
        this.movies = movies;
    }
}
