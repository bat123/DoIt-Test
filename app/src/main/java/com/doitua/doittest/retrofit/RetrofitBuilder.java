package com.doitua.doittest.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by batynchuk on 8/13/17.
 */

public class RetrofitBuilder {

    private final OkHttpClient client;

    public RetrofitBuilder() {

        HttpLoggingInterceptor.Level logLevel = HttpLoggingInterceptor.Level.BODY;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(logLevel);

        client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    }

    public Retrofit build() {

        return new Retrofit.Builder()
                .baseUrl("http://api.doitserver.in.ua/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
