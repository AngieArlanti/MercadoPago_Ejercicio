package com.angiearlanti.mercadopago_ejercicio.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.angiearlanti.mercadopago_ejercicio.R;

/**
 * Created by Angie on 1/12/2016.
 */
public class StepsUtils {

    public static final String AMOUNT = "Step1_amount";
    public static final int SELECTED_VALUES_REQUEST_CODE = 1;


    public static final String PAYMENT_TYPE = "credit_card";
    public static final  String PAYMENT_METHOD_ID = "payment_method_id";
    public static final  String CARD_ISSUER_ID = "card_issuer_id";
    public static final String RECOMMENDED_MESSAGE = "recommended_message";

    public static final String CARD_ISSUER_NAME =  "card_issuer_name";
    public static final String PAYMENT_METHOD_NAME = "payment_method_name";

    public static View getDialogLayout(Activity context, Intent data) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogLayout = inflater.inflate(R.layout.dialog, null);


        TextView amount = (TextView) dialogLayout.findViewById(R.id.dialog_textView_amount);
        TextView bank = (TextView) dialogLayout.findViewById(R.id.dialog_textView_bank);
        TextView paymentMethod = (TextView) dialogLayout.findViewById(R.id.dialog_textView_payment_method);
        TextView installments = (TextView) dialogLayout.findViewById(R.id.dialog_textView_installments);

        String stringAmount =context.getResources().getString(R.string.currency)+" "+data.getStringExtra(StepsUtils.AMOUNT);
        amount.setText(stringAmount);
        bank.setText(data.getStringExtra(StepsUtils.CARD_ISSUER_NAME));
        paymentMethod.setText(data.getStringExtra(StepsUtils.PAYMENT_METHOD_NAME));
        installments.setText(data.getStringExtra(StepsUtils.RECOMMENDED_MESSAGE));

        return dialogLayout;
    }
}
