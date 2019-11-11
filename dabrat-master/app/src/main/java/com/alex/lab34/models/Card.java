package com.alex.lab34.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Card implements Parcelable {

    @SerializedName("name")
    private String cardName;
    @SerializedName("imageUrl")
    private String imageUrl;

    public Card(String cardName, String releaseDate) {
        this.cardName = cardName;
        this.imageUrl = releaseDate;
    }

    public String getCardName() {
        return cardName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    protected Card(Parcel in) {
        cardName = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Card> CREATOR = new Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cardName);
        parcel.writeString(imageUrl);
    }
}
