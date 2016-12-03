package com.angiearlanti.mercadopago_ejercicio;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.angiearlanti.mercadopago_ejercicio.adapter.CardIssuerArrayAdapter;
import com.angiearlanti.mercadopago_ejercicio.api.CardIssuersTask;
import com.angiearlanti.mercadopago_ejercicio.api.PaymentMethodsTask;
import com.angiearlanti.mercadopago_ejercicio.model.CardIssuer;
import com.angiearlanti.mercadopago_ejercicio.model.CardIssuersParcelable;
import com.angiearlanti.mercadopago_ejercicio.utils.StepsUtils;

import java.util.ArrayList;
import java.util.List;

public class Step3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3);

        Intent intent = getIntent();

        CardIssuersParcelable parcelable = intent.getParcelableExtra(StepsUtils.CARD_ISSUERS);

        List<CardIssuer> list = parcelable.getCardIssuers();

        ListView listView = (ListView) findViewById(R.id.step3_listView);
        CardIssuerArrayAdapter adapter = new CardIssuerArrayAdapter (this,list);

        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

/*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //TODO: validate max and min amount
                String amount = context.getIntent().getStringExtra(StepsUtils.AMOUNT);

                Intent intent = new Intent(context, Step3Activity.class);
                intent.putExtra(StepsUtils.AMOUNT,amount);
                intent.putExtra(StepsUtils.PAYMENT_METHOD_ID,list.get(position).getId());

                context.startActivityForResult(intent,StepsUtils.SELECTED_VALUES_REQUEST_CODE);

            }
        });*/



    }
}
