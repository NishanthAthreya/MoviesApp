//
//  MoviesViewController.swift
//  MoviesApp
//
//  Created by Nishanth Athreya on 6/2/20.
//  Copyright © 2020 Nishanth Athreya. All rights reserved.
//

import Foundation

func getData() {
    let url = URL(string:"")
    let task = URLSession.shared.dataTask(with:url!, completionHandler: {(data, response, error) in
        do {
            let json = try JSONSerialization.jsonObject(with: data!, options: []) as? [String : Any]
            print(json!)
            DispatchQueue.main.async {
                
            }
        }
        catch {
            print("Error parsing data")
        }
    })
    
    task.resume()
}

