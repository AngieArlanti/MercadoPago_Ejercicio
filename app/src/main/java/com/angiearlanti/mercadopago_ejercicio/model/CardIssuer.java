package com.angiearlanti.mercadopago_ejercicio.model;

/**
 * Created by Angie on 1/12/2016.
 */
public class CardIssuer {

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
}
