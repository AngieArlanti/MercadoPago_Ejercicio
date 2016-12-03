package com.angiearlanti.mercadopago_ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.angiearlanti.mercadopago_ejercicio.api.PaymentMethodsTask;

import java.util.ArrayList;
import java.util.List;

public class Step2Activity extends AppCompatActivity {

    // Set the supported payment method types
    protected List<String> mSupportedPaymentTypes = new ArrayList<String>(){{
        add("credit_card");
    }};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);

        Intent selectedValuesIntent = getIntent();

        //new PaymentMethodsTask(this).execute();

        PaymentMethodsTask pm = new PaymentMethodsTask(this);

        pm.getPaymentMethods();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RESULT_OK) {
            if (resultCode == RESULT_OK) {


            }
        }
    }

}
