package com.alex.lab34.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alex.lab34.R;
import com.alex.lab34.models.Card;
import com.bumptech.glide.Glide;

import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Card> cardList;

    public CardsAdapter(Context context, List<Card> cardList) {
        this.context = context;
        this.cardList = cardList;
    }

    class CardsViewHolder extends RecyclerView.ViewHolder {

        private TextView cardName;
        private ImageView cardPhoto;

        CardsViewHolder(@NonNull View itemView) {
            super(itemView);
            cardName = itemView.findViewById(R.id.card_item_name);
            cardPhoto = itemView.findViewById(R.id.card_item_image);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardsViewHolder(LayoutInflater.from(context).inflate(R.layout.card_recycler_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CardsViewHolder cardsViewHolder = (CardsViewHolder) holder;
        cardsViewHolder.cardName.setText(cardList.get(position).getCardName());
        Glide.with(context).load(cardList.get(position).getImageUrl()).into(cardsViewHolder.cardPhoto);
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void updateAdapter(List<Card> cardList){
        this.cardList = cardList;
        notifyDataSetChanged();
    }

}
