package com.example.george.findbooks.api;

import android.support.annotation.NonNull;

import com.example.george.findbooks.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by George on 14.05.2018.
 */

public class ApiFactory {

    private static volatile Api sService;


    @NonNull
    public static Api getBookService() {
        Api service = sService;
        if (service == null) {
            synchronized (ApiFactory.class) {//используется если этот код уже выполняется в каком-то потоке,
                                                // то другой поток не сможет начать выполнение этого кода,
                                                // пока предыдущий поток не завершит выполнение.
                service = sService;
                if (service == null) {
                    service = sService = buildRetrofit().create(Api.class);
                }
            }
        }
        return service;
    }

    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }




}
