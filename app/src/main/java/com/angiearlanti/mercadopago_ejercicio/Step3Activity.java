package com.angiearlanti.mercadopago_ejercicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.angiearlanti.mercadopago_ejercicio.apicalls.CardIssuersTask;

public class Step3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3);
        setTitle(R.string.step3_title);

        CardIssuersTask ci = new CardIssuersTask(this);

        ci.getCardIssuers();



    }
}
