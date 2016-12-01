package com.angiearlanti.mercadopago_ejercicio.model;

/**
 * Created by Angie on 1/12/2016.
 */
public class CardNumber {

    private String lenght;
    private String validation;

    public CardNumber(String lenght, String validation) {
        this.lenght = lenght;
        this.validation = validation;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }
}
