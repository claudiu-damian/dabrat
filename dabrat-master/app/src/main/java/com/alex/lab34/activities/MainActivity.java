package com.alex.lab34.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alex.lab34.R;
import com.alex.lab34.adapters.CardsAdapter;
import com.alex.lab34.asynctask.GetCardsAsyncTask;
import com.alex.lab34.models.Card;
import com.alex.lab34.models.CardsResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardsAdapter cardsAdapter;
    private List<Card> cardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetCardsAsyncTask getCardsAsyncTask = new GetCardsAsyncTask(this, cardsResponse -> {
            cardList = cardsResponse.getCardsList();
            Log.d("List", "onResult() returned: " + cardList.size());
            setupAdapter(cardsResponse);
            // TODO: Animation

        });
        getCardsAsyncTask.execute();
    }


    private void setupAdapter(CardsResponse cardsResponse) {
        cardsAdapter = new CardsAdapter(MainActivity.this,
                cardsResponse.getCardsList());
        recyclerView = findViewById(R.id.cards_recycler_view);
        recyclerView.setLayoutManager(
                new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(cardsAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
