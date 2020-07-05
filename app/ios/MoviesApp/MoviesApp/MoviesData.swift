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
    private var movies: Array<String> = []
    
    /**
     Gets movie data.
     - Parameters
        - reloadData: handler for reloading data
     */
    func getData(reloadData: @escaping () -> ()) {
        let url = URL(string:"")
        let task = URLSession.shared.dataTask(with:url!, completionHandler: {(data, response, error) in
            do {
                let json = try JSONSerialization.jsonObject(with: data!, options: []) as? [String : Any]
                let movies = json?["movies"] as! Array<Dictionary<String,Any>>
                for (_, element) in movies.enumerated() {
                    self.movies.append(element["title"] as! String)
                }
                DispatchQueue.main.async {
                    reloadData()
                }
            }
            catch {
                print("Error parsing data")
            }
        })
        
        task.resume()
    }
    
    /**
     Returns movie data.
     */
    func getMovies() -> Array<String> {
        return movies
    }
}
