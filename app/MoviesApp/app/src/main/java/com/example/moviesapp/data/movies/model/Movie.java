package com.example.moviesapp.data.movies.model;

/**
 * Movie data model.
 */
public class Movie {

    private final String title;

    public Movie(String title) {
        this.title = title;
    }

    /**
     * Returns title.
     */
    public String getTitle() {
        return title;
    }
}
