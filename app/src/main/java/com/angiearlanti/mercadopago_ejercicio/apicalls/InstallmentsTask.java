package com.angiearlanti.mercadopago_ejercicio.apicalls;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.angiearlanti.mercadopago_ejercicio.R;
import com.angiearlanti.mercadopago_ejercicio.adapter.PayerCostsArrayAdapter;
import com.angiearlanti.mercadopago_ejercicio.model.Installment;
import com.angiearlanti.mercadopago_ejercicio.model.PayerCost;
import com.angiearlanti.mercadopago_ejercicio.service.MercadoPagoService;
import com.angiearlanti.mercadopago_ejercicio.utils.ApiUtils;
import com.angiearlanti.mercadopago_ejercicio.utils.StepsUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Angie on 3/12/2016.
 */

public class InstallmentsTask {

    private Activity context;

    public InstallmentsTask(final Activity context) {
        this.context = context;
    }


    public void getRecommendedMessage() {


        MercadoPagoService service = ApiUtils.getService(ApiUtils.BASE_URL,MercadoPagoService.class);

        final Intent intent = context.getIntent();
        String paymentMethodId = intent.getStringExtra(StepsUtils.PAYMENT_METHOD_ID);
        String cardIssuerId= intent.getStringExtra(StepsUtils.CARD_ISSUER_ID);
        String amount = intent.getStringExtra(StepsUtils.AMOUNT);



        Call<List<Installment>> cardIssuers = service.getInstallments(ApiUtils.PUBLIC_KEY, amount,paymentMethodId,cardIssuerId);

        cardIssuers.enqueue(new Callback<List<Installment>>() {
            @Override
            public void onResponse(Call<List<Installment>> call, Response<List<Installment>> response) {
                if (response.isSuccessful()) {



                    final List<Installment> list = response.body();

                    if(list.size()!=0) {
                        final Installment installment = list.get(0);

                        final List<PayerCost> payerCosts = installment.getPayer_costs();

                        ListView listView = (ListView) context.findViewById(R.id.step4_listView);

                        PayerCostsArrayAdapter adapter = new PayerCostsArrayAdapter(context, payerCosts);

                        adapter.notifyDataSetChanged();

                        listView.setAdapter(adapter);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                intent.putExtra(StepsUtils.RECOMMENDED_MESSAGE, payerCosts.get(position).getRecommended_message());
                                context.setResult(context.RESULT_OK, intent);
                                context.finish();

                            }
                        });

                    }else{

                        intent.putExtra(StepsUtils.CARD_ISSUER_NAME,context.getResources().getString(R.string.no_card_issuers));
                        intent.putExtra(StepsUtils.RECOMMENDED_MESSAGE,context.getResources().getString(R.string.no_installments));
                        context.setResult(context.RESULT_OK, intent);
                        context.finish();
                    }




                } else {
                    //puedo tener 404 o 500


                }

            }

            @Override
            public void onFailure(Call<List<Installment>> call, Throwable t) {
                Log.v("Step3Activity","onFailure");
                t.printStackTrace();
            }
        });


    }


}


