package com.angiearlanti.mercadopago_ejercicio.utils;

import com.angiearlanti.mercadopago_ejercicio.service.MercadoPagoService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Angie on 4/12/2016.
 */
public class ApiUtils {

    public static final String PUBLIC_KEY = "444a9ef5-8a6b-429f-abdf-587639155d88";
    public static final String BASE_URL = "https://api.mercadopago.com/";

    public static <T> T getService(String baseUrl, Class<T> service) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        T s = retrofit.create(service);

        return s;

    }
}
