package com.angiearlanti.mercadopago_ejercicio.model;

/**
 * Created by Angie on 1/12/2016.
 */
public class Setting {

    private Bin bin;
    private CardNumber card_number;
    private SecurityCode security_code;

    public Setting(Bin bin, CardNumber card_number, SecurityCode security_code) {
        this.bin = bin;
        this.card_number = card_number;
        this.security_code = security_code;
    }

    public Bin getBin() {
        return bin;
    }

    public void setBin(Bin bin) {
        this.bin = bin;
    }

    public CardNumber getCard_number() {
        return card_number;
    }

    public void setCard_number(CardNumber card_number) {
        this.card_number = card_number;
    }

    public SecurityCode getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(SecurityCode security_code) {
        this.security_code = security_code;
    }
}
