//
//  MovieDto.swift
//  MoviesApp
//
//  Created by Nishanth Athreya on 12/13/20.
//  Copyright © 2020 Nishanth Athreya. All rights reserved.
//

struct MovieDto: Decodable {
    let id: Int
    let title: String
    let imageUrl: String
}
