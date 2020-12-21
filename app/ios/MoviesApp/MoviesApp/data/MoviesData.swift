//
//  MoviesData.swift
//  MoviesApp
//
//  Created by Nishanth Athreya on 6/9/20.
//  Copyright © 2020 Nishanth Athreya. All rights reserved.
//

import Foundation

/**
 Movie data provider.
 */
class MoviesDataProvider {
    private var movies: [Movie]
    private let moviesDtoConverter: MoviesDtoConverter
    
    public init() {
        movies = []
        moviesDtoConverter = MoviesDtoConverter()
    }
    
    /**
         Gets movie data.
         - Parameters
            - reloadData: handler for reloading data
         */
        func getData(reloadData: @escaping () -> ()) {
            let url = URL(string:"")
            let task = URLSession.shared.dataTask(with:url!, completionHandler: {(data, response, error) in
                self.createMovies(from: data!)
                DispatchQueue.main.async {
                    reloadData()
                }
            })
            
            task.resume()
        }

    
    private func createMovies(from data: Data) {
        let decoder = JSONDecoder()
        guard let moviesDto = try? decoder.decode(MoviesDto.self, from: data) else {
            movies = []
            return
        }
        
        movies = moviesDtoConverter.convert(from: moviesDto)
    }
    
    /**
     Returns movie data.
     */
    func getMovies() -> [Movie] {
        return movies
    }
}
