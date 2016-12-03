package com.angiearlanti.mercadopago_ejercicio.api;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.angiearlanti.mercadopago_ejercicio.R;
import com.angiearlanti.mercadopago_ejercicio.Step3Activity;
import com.angiearlanti.mercadopago_ejercicio.Step4Activity;
import com.angiearlanti.mercadopago_ejercicio.adapter.CardIssuerArrayAdapter;
import com.angiearlanti.mercadopago_ejercicio.adapter.PaymentMethodArrayAdapter;
import com.angiearlanti.mercadopago_ejercicio.model.CardIssuer;
import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;
import com.angiearlanti.mercadopago_ejercicio.service.MercadoPagoService;
import com.angiearlanti.mercadopago_ejercicio.utils.PaymentMethodsTaskUtils;
import com.angiearlanti.mercadopago_ejercicio.utils.StepsUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Angie on 3/12/2016.
 */
public class CardIssuersTask {

    private Activity context;

    public CardIssuersTask(final Activity context) {
        this.context = context;
    }


    public void getCardIssuers() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadopago.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MercadoPagoService service = retrofit.create(MercadoPagoService.class);

        final String paymentMethodId = context.getIntent().getStringExtra(StepsUtils.PAYMENT_METHOD_ID);

        Log.v("Step3Activity-Intent",paymentMethodId);

        Call<List<CardIssuer>> cardIssuers = service.getCardIssuers(StepsUtils.PUBLIC_KEY, paymentMethodId);

        cardIssuers.enqueue(new Callback<List<CardIssuer>>() {
            @Override
            public void onResponse(Call<List<CardIssuer>> call, Response<List<CardIssuer>> response) {
                if (response.isSuccessful()) {


                    Log.v("Step3Activity","isSuccessful");
                    final List<CardIssuer> list = response.body();

                    if(list.isEmpty()){
                        //TODO: mandar a Step4 o si no hay banco no hay coutas??
                        Toast.makeText(context,R.string.toast_no_card_issuers,Toast.LENGTH_SHORT).show();
                    }else{
                        ListView listView = (ListView) context.findViewById(R.id.step3_listView);
                        CardIssuerArrayAdapter adapter = new CardIssuerArrayAdapter (context, list);

                        adapter.notifyDataSetChanged();

                        listView.setAdapter(adapter);


                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            //TODO: validate max and min amount
                            String amount = context.getIntent().getStringExtra(StepsUtils.AMOUNT);


                            Intent intent = new Intent(context, Step4Activity.class);
                            intent.putExtra(StepsUtils.AMOUNT,amount);
                            intent.putExtra(StepsUtils.PAYMENT_METHOD_ID,paymentMethodId);
                            intent.putExtra(StepsUtils.CARD_ISSUER_ID,list.get(position).getId());

                            context.startActivityForResult(intent,StepsUtils.SELECTED_VALUES_REQUEST_CODE);

                        }
                    });


                    }



                } else {
                    //puedo tener 404 o 500


                }

            }

            @Override
            public void onFailure(Call<List<CardIssuer>> call, Throwable t) {
                Log.v("Step3Activity","onFailure");
                t.printStackTrace();
            }
        });


    }


}
