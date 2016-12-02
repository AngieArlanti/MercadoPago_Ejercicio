package com.angiearlanti.mercadopago_ejercicio;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.angiearlanti.mercadopago_ejercicio.adapter.PaymentMethodArrayAdapter;
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

        //List<PaymentMethod> paymentMethodList = getPaymentMethods();
        new getPaymentMethods().execute();



    }

    private class getPaymentMethods extends AsyncTask<String, Void, List<PaymentMethod>>{

        private List<PaymentMethod> list =null;
        @Override
        protected List<PaymentMethod> doInBackground(String... params){

            try{

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
                            //TODO publishProgress ir completando la lista
                            ListView listView = (ListView) Step2Activity.this.findViewById(R.id.step2_listView);
                            PaymentMethodArrayAdapter adapter = new PaymentMethodArrayAdapter(Step2Activity.this, response.body());

                            adapter.notifyDataSetChanged();

                            listView.setAdapter(adapter);

                        } else {
                            //puedo tener 404 o 500
                            Log.v("Step2Activity","notSuccessful");

                        }

                    }

                    @Override
                    public void onFailure(Call<List<PaymentMethod>> call, Throwable t) {
                        Log.v("Step2Activity","onFailure");
                        t.printStackTrace();
                    }
                });

            }
            catch(Exception e){
                e.printStackTrace();

                return null;
            }
            return list;
        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RESULT_OK) {
            if (resultCode == RESULT_OK) {


            }
        }
    }

}
