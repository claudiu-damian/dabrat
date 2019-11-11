package com.alex.lab34.retrofit;

import com.alex.lab34.models.CardsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("cards")
    Call<CardsResponse> getCards();

}
