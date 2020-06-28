package com.example.moviesapp.data.movies.model;

import java.math.BigDecimal;

/**
 * Movie statistics data model.
 */
public class MovieStatistics {

    private final BigDecimal score;
    private final BigDecimal percentViewed;

    public MovieStatistics(
            BigDecimal score,
            BigDecimal percentViewed
    ) {
        this.score = score;
        this.percentViewed = percentViewed;
    }

    /**
     * Returns score.
     */
    public BigDecimal getScore() {
        return score;
    }

    /**
     * Returns percent viewed.
     */
    public BigDecimal getPercentViewed() {
        return percentViewed;
    }
}
