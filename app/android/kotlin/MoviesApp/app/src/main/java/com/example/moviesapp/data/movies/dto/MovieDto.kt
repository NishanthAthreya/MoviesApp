package com.example.moviesapp.data.movies.dto

/**
 * Movie dto.
 */
internal data class MovieDto(
        val id: String,
        val title: String,
        val imageUrl: String,
        val statistics: MovieStatisticsDto
)