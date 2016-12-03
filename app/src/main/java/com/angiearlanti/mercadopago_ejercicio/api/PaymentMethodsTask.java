package com.angiearlanti.mercadopago_ejercicio.api;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.angiearlanti.mercadopago_ejercicio.R;
import com.angiearlanti.mercadopago_ejercicio.Step2Activity;
import com.angiearlanti.mercadopago_ejercicio.Step3Activity;
import com.angiearlanti.mercadopago_ejercicio.adapter.PaymentMethodArrayAdapter;
import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;
import com.angiearlanti.mercadopago_ejercicio.service.MercadoPagoService;
import com.angiearlanti.mercadopago_ejercicio.utils.PaymentMethodsTaskUtils;
import com.angiearlanti.mercadopago_ejercicio.utils.StepsUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Angie on 2/12/2016.
 */


    public class PaymentMethodsTask {

    private Activity context;

    public PaymentMethodsTask(final Activity context) {
        this.context = context;
    }


    public void getPaymentMethods() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadopago.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MercadoPagoService service = retrofit.create(MercadoPagoService.class);

        Call<List<PaymentMethod>> paymentMethods = service.getPaymentMethods(StepsUtils.PUBLIC_KEY);

        paymentMethods.enqueue(new Callback<List<PaymentMethod>>() {
            @Override
            public void onResponse(Call<List<PaymentMethod>> call, Response<List<PaymentMethod>> response) {
                if (response.isSuccessful()) {



                    final List<PaymentMethod> list = PaymentMethodsTaskUtils.cleanTypes(response.body());

                    ListView listView = (ListView) context.findViewById(R.id.step2_listView);
                    PaymentMethodArrayAdapter adapter = new PaymentMethodArrayAdapter(context, list);

                    adapter.notifyDataSetChanged();

                    listView.setAdapter(adapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            //TODO: validate max and min amount



                            CardIssuersTask ci = new CardIssuersTask(context,list.get(position).getId());

                            ci.getCardIssuers();


                        }
                    });



                } else {
                    //puedo tener 404 o 500


                }

            }

            @Override
            public void onFailure(Call<List<PaymentMethod>> call, Throwable t) {

                t.printStackTrace();
            }
        });


    }

    }


