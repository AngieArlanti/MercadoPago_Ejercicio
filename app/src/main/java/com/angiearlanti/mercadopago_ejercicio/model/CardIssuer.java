package com.angiearlanti.mercadopago_ejercicio.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Angie on 1/12/2016.
 */
public class CardIssuer implements Parcelable {

    private String id;
    private String name;
    private String secure_thumbnail;
    private String thumbnail;

    public CardIssuer(String id, String name, String secure_thumbnail, String thumbnail) {
        this.id = id;
        this.name = name;
        this.secure_thumbnail = secure_thumbnail;
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecure_thumbnail() {
        return secure_thumbnail;
    }

    public void setSecure_thumbnail(String secure_thumbnail) {
        this.secure_thumbnail = secure_thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(thumbnail);
        dest.writeString(secure_thumbnail);
    }


    public static final Parcelable.Creator<CardIssuer> CREATOR
            = new Parcelable.Creator<CardIssuer>() {
        public CardIssuer createFromParcel(Parcel in) {
            return new CardIssuer(in);
        }

        public CardIssuer[] newArray(int size) {
            return new CardIssuer[size];
        }
    };

    private CardIssuer(Parcel in) {
        id = in.readString();
        name = in.readString();
        thumbnail = in.readString();
        secure_thumbnail = in.readString();
    }
}


