package com.angiearlanti.mercadopago_ejercicio.model;

import java.util.List;

/**
 * Created by Angie on 3/12/2016.
 */
public class Installment {

    private String payment_method_id;
    private String payment_type_id;
    private CardIssuer issuer;
    private List<PayerCost> payer_costs;

    public Installment(String payment_method_id, String payment_type_id, CardIssuer issuer, List<PayerCost> payer_costs) {
        this.payment_method_id = payment_method_id;
        this.payment_type_id = payment_type_id;
        this.issuer = issuer;
        this.payer_costs = payer_costs;
    }

    public String getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public String getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(String payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public CardIssuer getIssuer() {
        return issuer;
    }

    public void setIssuer(CardIssuer issuer) {
        this.issuer = issuer;
    }

    public List<PayerCost> getPayer_costs() {
        return payer_costs;
    }

    public void setPayer_costs(List<PayerCost> payer_costs) {
        this.payer_costs = payer_costs;
    }
}
