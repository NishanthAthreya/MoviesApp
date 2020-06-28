package com.example.moviesapp.data.util.retrofit

import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT = 20

/**
 * Factory that provides new retrofit instance.
 */
internal class RetrofitFactory {
    /**
    * Returns new retrofit instance.
    */
    fun build(): Retrofit = Retrofit.Builder()
                .baseUrl("")
                .client(clientBuilder().build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(
                        Schedulers.io()
                ))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()

    private fun clientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
                .readTimeout(
                        TIMEOUT.toLong(),
                        TimeUnit.SECONDS
                )
                .writeTimeout(
                        TIMEOUT.toLong(),
                        TimeUnit.SECONDS
                ).retryOnConnectionFailure(true)
    }
}