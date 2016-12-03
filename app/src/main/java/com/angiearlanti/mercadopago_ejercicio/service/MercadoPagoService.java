package com.angiearlanti.mercadopago_ejercicio.service;

import com.angiearlanti.mercadopago_ejercicio.model.CardIssuer;
import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Angie on 1/12/2016.
 */
public interface MercadoPagoService {

    //https://api.mercadopago.com/v1/payment_methods?public_key=PUBLIC_KEY

    @GET("/v1/payment_methods")
    Call<List<PaymentMethod>> getPaymentMethods(@Query("public_key") String publicKey);


    //v1/payment_methods/card_issuers?[payment_method_id=:id]
    //https://api.mercadopago.com/v1/payment_methods/card_issuers?public_key=PUBLIC_KEY&payment_method_id=MEDIO_DE_PAGO_SELECCIONADO

    @GET("/v1/payment_methods/card_issuers")
    Call<List<CardIssuer>> getCardIssuers(@Query("public_key") String publicKey, @Query("payment_method_id") String paymentMethodId);

}
