//
//  ViewController.swift
//  MoviesApp
//
//  Created by Nishanth Athreya on 6/2/20.
//  Copyright © 2020 Nishanth Athreya. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var movies: Array<String> = []

    @IBOutlet weak var moviesCollectionView: UICollectionView!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.navigationController?.isToolbarHidden = false
        moviesCollectionView.dataSource = self
        getData()
    }
    
    func getData() {
        let url = URL(string:"")
        let task = URLSession.shared.dataTask(with:url!, completionHandler: {(data, response, error) in
            do {
                let json = try JSONSerialization.jsonObject(with: data!, options: []) as? [String : Any]
                let movies = json?["movies"] as! Array<Dictionary<String,Any>>
                for (_, element) in movies.enumerated() {
                    self.movies.append(element["title"] as! String)
                }
                DispatchQueue.main.async {
                    self.moviesCollectionView.reloadData()
                }
            }
            catch {
                print("Error parsing data")
            }
        })
        
        task.resume()
    }

}

extension ViewController: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return movies.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "MovieCell", for: indexPath) as! LabelCollectionViewCell
        cell.setup(text: movies[indexPath.item])
        return cell
    }
    
    func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        let view = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: "sectionHeader", for: indexPath) as! HeaderCollectionReusableView
        view.isHidden = true
        return view
    }
}

