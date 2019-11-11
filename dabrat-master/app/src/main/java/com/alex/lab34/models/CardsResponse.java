package com.alex.lab34.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardsResponse implements Parcelable {

    @SerializedName("cards")
    private List<Card> cardsList;

    public CardsResponse(List<Card> categoriesList) {
        this.cardsList = categoriesList;
    }

    public CardsResponse() {
    }

    protected CardsResponse(Parcel in) {
        cardsList = in.createTypedArrayList(Card.CREATOR);
    }

    public static final Creator<CardsResponse> CREATOR = new Creator<CardsResponse>() {
        @Override
        public CardsResponse createFromParcel(Parcel in) {
            return new CardsResponse(in);
        }

        @Override
        public CardsResponse[] newArray(int size) {
            return new CardsResponse[size];
        }
    };

    public List<Card> getCardsList() {
        return cardsList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(cardsList);
    }
}
