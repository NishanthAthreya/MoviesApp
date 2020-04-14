package com.example.moviesapp.data.movies.model;

/**
 * Movie data model.
 */
public class Movie {

    private final String title;
    private final String id;
    private final String imageUrl;

    public Movie(
            String title,
            String id,
            String imageUrl
    ) {
        this.title = title;
        this.id = id;
        this.imageUrl = imageUrl;
    }

    /**
     * Returns title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns id.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns image url.
     */
    public String getImageUrl() {
        return imageUrl;
    }
}
