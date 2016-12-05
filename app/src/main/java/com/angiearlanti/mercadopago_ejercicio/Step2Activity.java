package com.angiearlanti.mercadopago_ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.angiearlanti.mercadopago_ejercicio.api.PaymentMethodsTask;
import com.angiearlanti.mercadopago_ejercicio.utils.StepsUtils;

import java.util.ArrayList;
import java.util.List;

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
