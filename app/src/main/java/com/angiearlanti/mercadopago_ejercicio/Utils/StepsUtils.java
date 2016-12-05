package com.angiearlanti.mercadopago_ejercicio.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.angiearlanti.mercadopago_ejercicio.R;
import com.angiearlanti.mercadopago_ejercicio.Step1Activity;

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
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TITLE = "error_title";

    private static View getDialogLayout(Activity context, Intent data) {

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

    public static AlertDialog getOkDialog(final Activity context,final Intent data) {

        View dialogLayout = getDialogLayout(context,data);


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.dialog_title)
                .setView(dialogLayout);

        builder.setPositiveButton(R.string.dialog_button_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                EditText editText= (EditText) context.findViewById(R.id.step1_editText);
                editText.getText().clear();
            }
        });

        return builder.create();
    }

    public static AlertDialog getErrorDialog(final Activity context,final Intent data) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.dialog_title)
                .setTitle(data.getStringExtra(StepsUtils.ERROR_TITLE))
                .setMessage(data.getStringExtra(StepsUtils.ERROR_MESSAGE));

        builder.setPositiveButton(R.string.dialog_button_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                EditText editText= (EditText) context.findViewById(R.id.step1_editText);
                editText.getText().clear();
            }
        });

        return builder.create();

    }
}
