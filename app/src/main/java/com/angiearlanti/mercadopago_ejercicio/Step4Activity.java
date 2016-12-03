package com.angiearlanti.mercadopago_ejercicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.angiearlanti.mercadopago_ejercicio.api.CardIssuersTask;
import com.angiearlanti.mercadopago_ejercicio.api.InstallmentsTask;

public class Step4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step4);

        InstallmentsTask it = new InstallmentsTask(this);

        it.getRecommendedMessage();
    }
}
