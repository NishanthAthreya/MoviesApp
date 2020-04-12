package com.example.moviesapp.data.movies.impl;

import com.example.moviesapp.data.movies.MoviesApi;
import com.example.moviesapp.data.movies.dto.MoviesDto;
import com.example.moviesapp.data.movies.model.Movie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import io.reactivex.Single;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MoviesRepoTest {

    @Mock
    private MoviesApi moviesApi;
    @Mock
    private MoviesDtoConverter moviesDtoConverter;

    private MoviesRepo classUnderTest;

    @Before
    public void setup() {
        classUnderTest = new MoviesRepo(
                moviesApi,
                moviesDtoConverter
        );
    }

    @Test
    public void movies() {
        MoviesDto moviesDto = mock(MoviesDto.class);
        List<Movie> movies = Collections.singletonList(mock(Movie.class));

        when(moviesApi.movies()).thenReturn(Single.just(moviesDto));
        when(moviesDtoConverter.apply(moviesDto)).thenReturn(movies);

        //noinspection unchecked
        classUnderTest.movies()
                .test()
                .assertResult(movies);
    }
}
