package com.angiearlanti.mercadopago_ejercicio.async_task;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.angiearlanti.mercadopago_ejercicio.R;
import com.angiearlanti.mercadopago_ejercicio.adapter.PaymentMethodArrayAdapter;
import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;
import com.angiearlanti.mercadopago_ejercicio.service.MercadoPagoService;
import com.angiearlanti.mercadopago_ejercicio.utils.StepsUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Angie on 2/12/2016.
 */


    public class PaymentMethodsAsyncTask {

    private Activity context;

    public PaymentMethodsAsyncTask(final Activity context) {
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
                    Log.v("Step2Activity", "isSuccessful");

                    //TODO publishProgress ir completando la lista
                    ListView listView = (ListView) context.findViewById(R.id.step2_listView);
                    PaymentMethodArrayAdapter adapter = new PaymentMethodArrayAdapter(context, response.body());


                    adapter.notifyDataSetChanged();

                    listView.setAdapter(adapter);

                } else {
                    //puedo tener 404 o 500
                    Log.v("Step2Activity", "notSuccessful");

                }

            }

            @Override
            public void onFailure(Call<List<PaymentMethod>> call, Throwable t) {
                Log.v("Step2Activity", "onFailure");
                t.printStackTrace();
            }
        });


    }

    }


