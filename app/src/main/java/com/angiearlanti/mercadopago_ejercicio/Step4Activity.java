package com.angiearlanti.mercadopago_ejercicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.angiearlanti.mercadopago_ejercicio.apicalls.InstallmentsTask;

public class Step4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step4);
        setTitle(R.string.step4_title);

        InstallmentsTask it = new InstallmentsTask(this);

        it.getRecommendedMessage();
    }
}
