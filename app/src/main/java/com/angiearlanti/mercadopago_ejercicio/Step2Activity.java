package com.angiearlanti.mercadopago_ejercicio;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.angiearlanti.mercadopago_ejercicio.adapter.PaymentMethodArrayAdapter;
import com.angiearlanti.mercadopago_ejercicio.async_task.PaymentMethodsAsyncTask;
import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;
import com.angiearlanti.mercadopago_ejercicio.service.MercadoPagoService;
import com.angiearlanti.mercadopago_ejercicio.utils.StepsUtils;

import org.w3c.dom.Text;

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

        //new PaymentMethodsAsyncTask(this).execute();

        PaymentMethodsAsyncTask pm = new PaymentMethodsAsyncTask(this);

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
