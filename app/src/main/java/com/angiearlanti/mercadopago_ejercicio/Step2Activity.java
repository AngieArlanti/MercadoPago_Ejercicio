package com.angiearlanti.mercadopago_ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;
import com.angiearlanti.mercadopago_ejercicio.service.MercadoPagoService;
import com.angiearlanti.mercadopago_ejercicio.utils.StepsUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        //List<PaymentMethod> paymentMethodList = getPaymentMethods();
        getPaymentMethods();

    }

    private void getPaymentMethods() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadopago.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MercadoPagoService service = retrofit.create(MercadoPagoService.class);

        Call<List<PaymentMethod>> saludo = service.getPaymentMethods(StepsUtils.PUBLIC_KEY);

        saludo.enqueue(new Callback<List<PaymentMethod>>() {
            @Override
            public void onResponse(Call<List<PaymentMethod>> call, Response<List<PaymentMethod>> response) {
                if (response.isSuccessful()) {
                    Log.v("Step2Activity","isSuccessful");
                    TextView textView = (TextView) findViewById(R.id.textView);
                    textView.setText(response.body().get(0).getName());

                } else {
                    //puedo tener 404 o 500
                    Log.v("Step2Activity","notSuccessful");

                }

            }

            @Override
            public void onFailure(Call<List<PaymentMethod>> call, Throwable t) {
                Log.v("Step2Activity","onFailure");
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RESULT_OK) {
            if (resultCode == RESULT_OK) {


            }
        }
    }

}
