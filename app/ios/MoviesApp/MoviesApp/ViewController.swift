//
//  ViewController.swift
//  MoviesApp
//
//  Created by Nishanth Athreya on 6/2/20.
//  Copyright © 2020 Nishanth Athreya. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    let moviesProvider = MoviesDataProvider()

    @IBOutlet weak var moviesCollectionView: UICollectionView!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.navigationController?.isToolbarHidden = false
        moviesCollectionView.dataSource = self
        moviesProvider.getData(
            reloadData: {
                self.moviesCollectionView.reloadData()
            }
        )
    }

}

extension ViewController: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return moviesProvider.getMovies().count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "MovieCell", for: indexPath) as! LabelCollectionViewCell
        cell.setup(text: moviesProvider.getMovies()[indexPath.item].title)

        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        let view = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: "sectionHeader", for: indexPath) as! HeaderCollectionReusableView
        view.isHidden = true
        return view
    }
}

