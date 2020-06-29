package com.example.moviesapp.data.movies.model

import java.math.BigDecimal

/**
 * Movie statistics data model.
 */
internal data class MovieStatistics(
        val score: BigDecimal,
        val percentViewed: BigDecimal
)