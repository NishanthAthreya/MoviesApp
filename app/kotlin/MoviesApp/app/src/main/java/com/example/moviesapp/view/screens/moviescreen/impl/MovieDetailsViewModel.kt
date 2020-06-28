package com.example.moviesapp.view.screens.moviescreen.impl

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.moviesapp.data.movies.impl.MoviesRepo
import com.example.moviesapp.view.screens.moviescreen.model.MovieScreenDetails
import com.example.ui_components.webimage.model.WebImage
import io.reactivex.android.schedulers.AndroidSchedulers

internal class MovieDetailsViewModel(private val movieScreenDetails: MovieScreenDetails) {

    private val webImage = MutableLiveData<WebImage>()
    private val title = MutableLiveData<String>()
    private val moviesRepo = MoviesRepo()

    init{
        onLoad()
    }

    fun title() = title

    fun image() = webImage

    @SuppressLint("CheckResult")
    private fun onLoad() {
        webImage.value = WebImage(null) // initial value
        moviesRepo.movie(movieScreenDetails.id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    title.value = it.title
                    webImage.value = WebImage(it.imageUrl)
                }
    }
}