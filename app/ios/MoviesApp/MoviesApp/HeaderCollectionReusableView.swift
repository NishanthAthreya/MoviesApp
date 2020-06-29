//
//  HeaderCollectionReusableView.swift
//  MoviesApp
//
//  Created by Nishanth Athreya on 6/10/20.
//  Copyright © 2020 Nishanth Athreya. All rights reserved.
//

import UIKit

class HeaderCollectionReusableView: UICollectionReusableView {
        
    @IBOutlet weak var sectionHeader: UILabel!
    
    func setup(value: String) {
        sectionHeader.text = value
    }
}
