package com.angiearlanti.mercadopago_ejercicio.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.angiearlanti.mercadopago_ejercicio.R;
import com.angiearlanti.mercadopago_ejercicio.Step3Activity;
import com.angiearlanti.mercadopago_ejercicio.adapter.CardIssuerArrayAdapter;
import com.angiearlanti.mercadopago_ejercicio.adapter.PaymentMethodArrayAdapter;
import com.angiearlanti.mercadopago_ejercicio.model.CardIssuer;
import com.angiearlanti.mercadopago_ejercicio.model.CardIssuersParcelable;
import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;
import com.angiearlanti.mercadopago_ejercicio.service.MercadoPagoService;
import com.angiearlanti.mercadopago_ejercicio.utils.PaymentMethodsTaskUtils;
import com.angiearlanti.mercadopago_ejercicio.utils.StepsUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
    private String paymentMethodId;

    public CardIssuersTask(final Activity context, final String paymentMethodId) {
        this.context = context;
        this.paymentMethodId = paymentMethodId;
    }


    public void getCardIssuers() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadopago.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MercadoPagoService service = retrofit.create(MercadoPagoService.class);

        Call<List<CardIssuer>> cardIssuers = service.getCardIssuers(StepsUtils.PUBLIC_KEY, paymentMethodId);

        cardIssuers.enqueue(new Callback<List<CardIssuer>>() {
            @Override
            public void onResponse(Call<List<CardIssuer>> call, Response<List<CardIssuer>> response) {
                if (response.isSuccessful()) {


                    List<CardIssuer> list = response.body();
                    String amount = context.getIntent().getStringExtra(StepsUtils.AMOUNT);

                    CardIssuersParcelable cardIssuers = new CardIssuersParcelable((ArrayList<CardIssuer>) list);



                    if(list.isEmpty()){
                        //TODO Intent a Step4Installments o no hay installments si no hay banco?
                        Toast.makeText(context,R.string.toast_no_card_issuers,Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent(context, Step3Activity.class);
                        intent.putExtra(StepsUtils.AMOUNT,amount);
                        intent.putExtra(StepsUtils.PAYMENT_METHOD_ID,paymentMethodId);
                        intent.putExtra(StepsUtils.CARD_ISSUERS,cardIssuers);

                        context.startActivityForResult(intent,StepsUtils.SELECTED_VALUES_REQUEST_CODE);
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
