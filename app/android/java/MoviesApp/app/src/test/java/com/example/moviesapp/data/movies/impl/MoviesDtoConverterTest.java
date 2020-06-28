package com.example.moviesapp.data.movies.impl;

import com.example.moviesapp.data.movies.dto.MovieDto;
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
        String id= "1";
        String title = "title";
        String imageUrl = "imageUrl";
        MovieDto movieDto = new MovieDto(
                id,
                title,
                imageUrl
        );
        MoviesListDto moviesListDto = new MoviesListDto(Collections.singletonList(movieDto));

        List<Movie> result = classUnderTest.apply(moviesListDto);

        assertNotNull(result);
        assertEquals(
                1,
                result.size()
        );

        Movie movie = result.get(0);

        assertNotNull(movie);
        assertEquals(
                id,
                movie.getId()
        );
        assertEquals(
                title,
                movie.getTitle()
        );
        assertEquals(
                imageUrl,
                movie.getImageUrl()
        );
    }
}
