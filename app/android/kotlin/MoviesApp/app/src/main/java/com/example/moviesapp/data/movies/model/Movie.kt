package com.example.moviesapp.data.movies.model

/**
 * Movie data model.
 */
internal data class Movie (
        val id: String,
        val title: String,
        val imageUrl: String,
        val statistics: MovieStatistics
)