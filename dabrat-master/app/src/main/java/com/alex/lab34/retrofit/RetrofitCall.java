package com.alex.lab34.retrofit;

import com.alex.lab34.models.CardsResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCall {

    public static final String BASE_URL = "https://api.magicthegathering.io/v1/";
    private static RetrofitCall retrofitInstance;
    private static Retrofit retrofit;

    public RetrofitCall() {

    }

    public static RetrofitCall getInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new RetrofitCall();
        }
        return retrofitInstance;
    }

    public static Retrofit getRetrofit(String url) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .writeTimeout(30, TimeUnit.MILLISECONDS)
                .build();


        //httpClient.retryOnConnectionFailure(true);


        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())

                .build();
        return retrofit;
    }

    public static Call<CardsResponse> getAllCardsData(String baseUrl) {
        RetrofitInterface retrofitInterface = getInstance().getRetrofit(baseUrl).create(RetrofitInterface.class);
        return retrofitInterface.getCards();
    }
}

