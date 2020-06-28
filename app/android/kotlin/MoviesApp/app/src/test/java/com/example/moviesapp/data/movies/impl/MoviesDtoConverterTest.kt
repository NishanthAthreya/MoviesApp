package com.example.moviesapp.data.movies.impl

import com.example.moviesapp.data.movies.dto.MovieDto
import com.example.moviesapp.data.movies.dto.MovieStatisticsDto
import com.example.moviesapp.data.movies.dto.MoviesListDto
import com.example.moviesapp.data.movies.model.Movie
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MoviesDtoConverterTest {

    private lateinit var classUnderTest: MoviesDtoConverter

    @Before
    fun setup() {
        classUnderTest = MoviesDtoConverter()
    }

    @Test
    fun invoke() {
        val id = "1"
        val title = "title"
        val imageUrl = "imageUrl"
        val score = 95.0
        val percentViewed = 98.0
        val movieDto = MovieDto(
                id,
                title,
                imageUrl,
                MovieStatisticsDto(
                        score,
                        percentViewed
                )
        )
        val moviesListDto = MoviesListDto(listOf(movieDto))

        val result = classUnderTest(moviesListDto)

        assertNotNull(result)
        assertEquals(
                1,
                result.size
                        .toLong())

        val movie: Movie = result[0]

        with(movie) {
            assertNotNull(this)
            assertEquals(
                    id,
                    this.id
            )
            assertEquals(
                    title,
                    this.title
            )
            assertEquals(
                    imageUrl,
                    this.imageUrl
            )
            with(statistics) {
                assertNotNull(this)
                assertEquals(
                        score,
                        this.score
                )
                assertEquals(
                        percentViewed,
                        this.percentViewed
                )
            }
        }
    }
}