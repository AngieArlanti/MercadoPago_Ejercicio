package com.angiearlanti.mercadopago_ejercicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.angiearlanti.mercadopago_ejercicio.Utils.StepsUtils;

public class Step2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step2);

        String amount = getIntent().getStringExtra(StepsUtils.AMOUNT);

        TextView textView = (TextView) findViewById(R.id.textView);

        textView.setText(amount);

    }
}
