package com.example.moviesapp.data.movies.dto;

import java.math.BigDecimal;

/**
 * Movie statistics dto.
 */
public class MovieStatisticsDto {

    public final BigDecimal score;
    public final BigDecimal percentViewed;

    public MovieStatisticsDto(
            BigDecimal score,
            BigDecimal percentViewed
    ) {
        this.score = score;
        this.percentViewed = percentViewed;
    }
}
