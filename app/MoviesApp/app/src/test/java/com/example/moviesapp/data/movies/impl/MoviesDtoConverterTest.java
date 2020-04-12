package com.example.moviesapp.data.movies.impl;

import com.example.moviesapp.data.movies.dto.MovieDto;
import com.example.moviesapp.data.movies.dto.MoviesDto;
import com.example.moviesapp.data.movies.dto.MoviesListDto;
import com.example.moviesapp.data.movies.model.Movie;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MoviesDtoConverterTest {

    private MoviesDtoConverter classUnderTest;

    @Before
    public void setup() {
        classUnderTest = new MoviesDtoConverter();
    }

    @Test
    public void apply() {
        String title = "title";
        MovieDto movieDto = new MovieDto(
                "1",
                title
        );
        MoviesListDto moviesListDto = new MoviesListDto(Collections.singletonList(movieDto));
        MoviesDto moviesDto = new MoviesDto(moviesListDto);

        List<Movie> result = classUnderTest.apply(moviesDto);

        assertNotNull(result);
        assertEquals(
                1,
                result.size()
        );

        Movie movie = result.get(0);

        assertNotNull(movie);
        assertEquals(
                title,
                movie.getTitle()
        );
    }
}
