package com.example.moviesapp.data.movies;

import com.example.moviesapp.data.movies.dto.MoviesDto;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface MoviesApi {

    @GET("/api/v1/movies")
    Single<MoviesDto> movies();
}
