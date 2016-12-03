package com.angiearlanti.mercadopago_ejercicio.model;

import java.util.List;

/**
 * Created by Angie on 3/12/2016.
 */
public class PayerCosts {

    private Number installments;
    private Number installment_rate;
    private List<String> labels;
    private Number min_allowed_amount;
    private Number max_allowed_amount;
    private String recommended_message;
    private Number installment_amount;
    private Number total_amount;

    public PayerCosts(Number installments, Number installment_rate, List<String> labels, Number min_allowed_amount, Number max_allowed_amount, String recommended_message, Number installment_amount, Number total_amount) {
        this.installments = installments;
        this.installment_rate = installment_rate;
        this.labels = labels;
        this.min_allowed_amount = min_allowed_amount;
        this.max_allowed_amount = max_allowed_amount;
        this.recommended_message = recommended_message;
        this.installment_amount = installment_amount;
        this.total_amount = total_amount;
    }

    public Number getInstallments() {
        return installments;
    }

    public void setInstallments(Number installments) {
        this.installments = installments;
    }

    public Number getInstallment_rate() {
        return installment_rate;
    }

    public void setInstallment_rate(Number installment_rate) {
        this.installment_rate = installment_rate;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Number getMin_allowed_amount() {
        return min_allowed_amount;
    }

    public void setMin_allowed_amount(Number min_allowed_amount) {
        this.min_allowed_amount = min_allowed_amount;
    }

    public Number getMax_allowed_amount() {
        return max_allowed_amount;
    }

    public void setMax_allowed_amount(Number max_allowed_amount) {
        this.max_allowed_amount = max_allowed_amount;
    }

    public String getRecommended_message() {
        return recommended_message;
    }

    public void setRecommended_message(String recommended_message) {
        this.recommended_message = recommended_message;
    }

    public Number getInstallment_amount() {
        return installment_amount;
    }

    public void setInstallment_amount(Number installment_amount) {
        this.installment_amount = installment_amount;
    }

    public Number getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Number total_amount) {
        this.total_amount = total_amount;
    }
}
