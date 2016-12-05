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
import com.angiearlanti.mercadopago_ejercicio.utils.ApiUtils;
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


        MercadoPagoService service = ApiUtils.getService(ApiUtils.BASE_URL,MercadoPagoService.class);

        final Intent intent = context.getIntent();
        final String paymentMethodId = intent.getStringExtra(StepsUtils.PAYMENT_METHOD_ID);
        final String amount = context.getIntent().getStringExtra(StepsUtils.AMOUNT);
        final String paymentMethodName = intent.getStringExtra(StepsUtils.PAYMENT_METHOD_NAME);



        Call<List<CardIssuer>> cardIssuers = service.getCardIssuers(ApiUtils.PUBLIC_KEY, paymentMethodId);

        cardIssuers.enqueue(new Callback<List<CardIssuer>>() {
            @Override
            public void onResponse(Call<List<CardIssuer>> call, Response<List<CardIssuer>> response) {
                if (response.isSuccessful()) {



                    final List<CardIssuer> list = response.body();

                    if(list.isEmpty()){

                        intent.putExtra(StepsUtils.CARD_ISSUER_NAME,context.getResources().getString(R.string.no_card_issuers));
                        intent.putExtra(StepsUtils.RECOMMENDED_MESSAGE,context.getResources().getString(R.string.no_installments));
                        context.setResult(context.RESULT_OK, intent);
                        context.finish();
                    }else{
                        ListView listView = (ListView) context.findViewById(R.id.step3_listView);
                        CardIssuerArrayAdapter adapter = new CardIssuerArrayAdapter (context, list);

                        adapter.notifyDataSetChanged();

                        listView.setAdapter(adapter);


                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            //TODO: validate max and min amount

                            Intent i = new Intent(context, Step4Activity.class);
                            i.putExtra(StepsUtils.AMOUNT,amount);
                            i.putExtra(StepsUtils.PAYMENT_METHOD_ID,paymentMethodId);
                            i.putExtra(StepsUtils.PAYMENT_METHOD_NAME,paymentMethodName);
                            i.putExtra(StepsUtils.CARD_ISSUER_ID,list.get(position).getId());
                            i.putExtra(StepsUtils.CARD_ISSUER_NAME,list.get(position).getName());

                            i.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                            context.startActivity(i);
                            context.finish();

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
