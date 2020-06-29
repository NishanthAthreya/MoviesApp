//
//  LabelCollectionViewCell.swift
//  MoviesApp
//
//  Created by Nishanth Athreya on 6/28/20.
//  Copyright © 2020 Nishanth Athreya. All rights reserved.
//

import UIKit

class LabelCollectionViewCell: UICollectionViewCell {
    
    @IBOutlet weak var label: UILabel!
    
    func setup(text: String) {
        label.text = text
    }
}
