package com.angiearlanti.mercadopago_ejercicio.model;

/**
 * Created by Angie on 1/12/2016.
 */
public class SecurityCode {

    private String mode;
    private Number length;
    private String card_location;

    public SecurityCode(String mode, Number length, String card_location) {
        this.mode = mode;
        this.length = length;
        this.card_location = card_location;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Number getLength() {
        return length;
    }

    public void setLength(Number length) {
        this.length = length;
    }

    public String getCard_location() {
        return card_location;
    }

    public void setCard_location(String card_location) {
        this.card_location = card_location;
    }
}
