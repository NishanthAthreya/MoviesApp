//
//  MoviesDtoConverter.swift
//  MoviesApp
//
//  Created by Nishanth Athreya on 12/13/20.
//  Copyright © 2020 Nishanth Athreya. All rights reserved.
//

struct MoviesDtoConverter {
    
    func convert(from movies: MoviesDto) -> [Movie] {
        return movies.movies.map {
            convertMovie(from: $0)
        }
    }
    
    private func convertMovie(from movie: MovieDto) -> Movie {
        return Movie(
            id: movie.id,
            title: movie.title,
            imageUrl: movie.imageUrl)
    }
}
