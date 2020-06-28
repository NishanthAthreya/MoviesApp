package com.example.moviesapp.data.movies.dto;

/**
 * Movie dto.
 */
public class MovieDto {

    public final String id;
    public final String title;
    public final String imageUrl;
    public final MovieStatisticsDto statistics;

    public MovieDto(
            String id,
            String title,
            String imageUrl,
            MovieStatisticsDto statistics
    ) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.statistics = statistics;
    }
}
