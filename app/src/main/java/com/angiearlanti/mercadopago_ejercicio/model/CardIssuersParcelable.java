package com.angiearlanti.mercadopago_ejercicio.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Angie on 3/12/2016.
 */

public class CardIssuersParcelable implements Parcelable{

    private ArrayList<CardIssuer> cardIssuers;

    public CardIssuersParcelable(ArrayList<CardIssuer> cardIssuers) {
        this.cardIssuers = cardIssuers;
    }

    public ArrayList<CardIssuer> getCardIssuers() {
        return cardIssuers;
    }

    public void setCardIssuers(ArrayList<CardIssuer> cardIssuers) {
        this.cardIssuers = cardIssuers;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(cardIssuers);
    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CardIssuersParcelable createFromParcel(Parcel in) {
            return new CardIssuersParcelable (in);
        }

        public CardIssuersParcelable [] newArray(int size) {
            return new CardIssuersParcelable [size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    private CardIssuersParcelable (Parcel in) {

        cardIssuers= new ArrayList<CardIssuer>();
        in.readList(cardIssuers,null);

    }
}
