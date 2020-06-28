package com.example.moviesapp.data.util.retrofit;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Factory that provides new retrofit instance.
 */
public class RetrofitFactory {

    private static final int TIMEOUT = 20;

    /**
     * Returns new retrofit instance.
     */
    public Retrofit build() {
        return new Retrofit.Builder()
                .baseUrl("")
                .client(clientBuilder().build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(
                        Schedulers.io()
                ))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();
    }

    private OkHttpClient.Builder clientBuilder() {
        return new OkHttpClient.Builder()
                .readTimeout(
                        TIMEOUT,
                        TimeUnit.SECONDS
                )
                .writeTimeout(
                        TIMEOUT,
                        TimeUnit.SECONDS
                ).retryOnConnectionFailure(true);
    }
}
