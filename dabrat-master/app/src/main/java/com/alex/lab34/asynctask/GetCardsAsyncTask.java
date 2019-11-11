package com.alex.lab34.asynctask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.alex.lab34.models.CardsResponse;
import com.alex.lab34.retrofit.RetrofitCall;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class GetCardsAsyncTask extends AsyncTask<Void, Void, CardsResponse> {

    @SuppressLint("StaticFieldLeak")
    private Context context;
    private ResultListener resultListener;

    public GetCardsAsyncTask(Context context, ResultListener resultListener) {
        this.context = context;
        this.resultListener = resultListener;
    }

    @Override
    protected CardsResponse doInBackground(Void... voids) {
        CardsResponse cardsResponse = new CardsResponse();
        Call<CardsResponse> cardsResponseCall = RetrofitCall
                .getAllCardsData(RetrofitCall.BASE_URL);
        try {
            Response<CardsResponse> response = cardsResponseCall.execute();
            cardsResponse = response.body();
            Log.d("Async", "doInBackground() returned: " + cardsResponse.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cardsResponse;
    }

    @Override
    protected void onPostExecute(CardsResponse cardsResponse) {
        super.onPostExecute(cardsResponse);
        resultListener.onResult(cardsResponse);
    }

    public interface ResultListener {
        void onResult(CardsResponse cardsResponse);
    }
}