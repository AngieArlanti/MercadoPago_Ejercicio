package com.angiearlanti.mercadopago_ejercicio.model;

/**
 * Created by Angie on 1/12/2016.
 */
public class Bin {

    private String pattern;
    private String exclusion_pattern;
    private String installments_pattern;

    public Bin(String pattern, String exclusion_pattern, String installments_pattern) {
        this.pattern = pattern;
        this.exclusion_pattern = exclusion_pattern;
        this.installments_pattern = installments_pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getExclusion_pattern() {
        return exclusion_pattern;
    }

    public void setExclusion_pattern(String exclusion_pattern) {
        this.exclusion_pattern = exclusion_pattern;
    }

    public String getInstallments_pattern() {
        return installments_pattern;
    }

    public void setInstallments_pattern(String installments_pattern) {
        this.installments_pattern = installments_pattern;
    }
}
