package com.example.moviesapp.view.screens.moviescreen.impl;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviesapp.data.movies.impl.MoviesRepo;
import com.example.moviesapp.view.screens.moviescreen.model.MovieScreenDetails;
import com.example.ui_components.webimage.model.WebImage;

import java.io.InputStream;
import java.net.URL;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MovieDetailsViewModel {

    private final MovieScreenDetails movieScreenDetails;
    private final MutableLiveData<WebImage> webImage;
    private final MutableLiveData<String> title;
    private final MoviesRepo moviesRepo;

    MovieDetailsViewModel(MovieScreenDetails movieScreenDetails) {
        this.movieScreenDetails = movieScreenDetails;
        this.webImage = new MutableLiveData<>();
        this.title = new MutableLiveData<>();
        this.moviesRepo = new MoviesRepo();
        onLoad();
    }

    private void onLoad() {
        try {
            this.webImage.setValue(new WebImage(null));
        } catch(Exception e) {
            e.printStackTrace();
        }

        moviesRepo.movie(movieScreenDetails.getId())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movie -> {
                    title.setValue(movie.getTitle());
                    webImage.setValue(new ImageTask().execute(movie.getImageUrl()).get());
                });
    }

    public LiveData<String> title() {
        return title;
    }

    public LiveData<WebImage> image() {
        return webImage;
    }

    @SuppressLint("StaticFieldLeak")
    private class ImageTask extends AsyncTask<String, Void, WebImage> {

        @Override
        protected WebImage doInBackground(String... urls) {
            try {
                return new WebImage(bitmap(urls[0]));
            } catch(Exception e) {
                return new WebImage(null);
            }
        }
    }

    private Bitmap bitmap(String url) throws Exception {
        return BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
    }
}
