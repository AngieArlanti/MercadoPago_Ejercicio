package com.angiearlanti.mercadopago_ejercicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.angiearlanti.mercadopago_ejercicio.apicalls.PaymentMethodsTask;

public class Step2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);
        setTitle(R.string.step2_title);

        PaymentMethodsTask pm = new PaymentMethodsTask(this);

        pm.getPaymentMethods();

    }


}
