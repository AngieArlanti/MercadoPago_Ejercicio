package com.angiearlanti.mercadopago_ejercicio.apicalls;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.angiearlanti.mercadopago_ejercicio.R;
import com.angiearlanti.mercadopago_ejercicio.Step3Activity;
import com.angiearlanti.mercadopago_ejercicio.adapter.PaymentMethodArrayAdapter;
import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;
import com.angiearlanti.mercadopago_ejercicio.service.MercadoPagoService;
import com.angiearlanti.mercadopago_ejercicio.utils.ApiUtils;
import com.angiearlanti.mercadopago_ejercicio.utils.TaskUtils;
import com.angiearlanti.mercadopago_ejercicio.utils.StepsUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Angie on 2/12/2016.
 */


    public class PaymentMethodsTask {

    private Activity context;

    public PaymentMethodsTask(final Activity context) {
        this.context = context;
    }


    public void getPaymentMethods() {

        MercadoPagoService service = ApiUtils.getService(ApiUtils.BASE_URL,MercadoPagoService.class);



        Call<List<PaymentMethod>> paymentMethods = service.getPaymentMethods(ApiUtils.PUBLIC_KEY);

        paymentMethods.enqueue(new Callback<List<PaymentMethod>>() {
            @Override
            public void onResponse(Call<List<PaymentMethod>> call, Response<List<PaymentMethod>> response) {
                if (response.isSuccessful()) {



                    final List<PaymentMethod> list = TaskUtils.cleanTypes(response.body());

                    ListView listView = (ListView) context.findViewById(R.id.step2_listView);
                    PaymentMethodArrayAdapter adapter = new PaymentMethodArrayAdapter(context, list);

                    adapter.notifyDataSetChanged();

                    listView.setAdapter(adapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            String amount = context.getIntent().getStringExtra(StepsUtils.AMOUNT);

                            Number max = list.get(position).getMax_allowed_amount();
                            Number min = list.get(position).getMin_allowed_amount();

                            if (TaskUtils.checkPaymentMethodAmount(context,amount,min,max)){
                                Intent intent = new Intent(context, Step3Activity.class);
                                intent.putExtra(StepsUtils.AMOUNT,amount);
                                intent.putExtra(StepsUtils.PAYMENT_METHOD_ID,list.get(position).getId());
                                intent.putExtra(StepsUtils.PAYMENT_METHOD_NAME,list.get(position).getName());

                                intent.setFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                                context.startActivity(intent);
                                context.finish();
                            }



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


