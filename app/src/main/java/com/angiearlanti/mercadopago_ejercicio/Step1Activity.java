package com.angiearlanti.mercadopago_ejercicio;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.angiearlanti.mercadopago_ejercicio.utils.StepsUtils;

import java.util.Locale;

public class Step1Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1);

        setTitle(R.string.step1_title);

        final Button button = (Button) findViewById(R.id.step1_next_button);
        final EditText editText = (EditText) findViewById(R.id.step1_editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Validate editText
                String amount= editText.getText().toString();
                //BigDecimal amount = new BigDecimal(amountString).setScale(2, BigDecimal.ROUND_FLOOR).divide(new BigDecimal(100), BigDecimal.ROUND_FLOOR);

                Intent intent = new Intent(Step1Activity.this,Step2Activity.class);

                intent.putExtra(StepsUtils.AMOUNT,amount);

                startActivityForResult(intent,StepsUtils.SELECTED_VALUES_REQUEST_CODE);

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == StepsUtils.SELECTED_VALUES_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View dialogLayout = inflater.inflate(R.layout.dialog, null);


                TextView amount = (TextView) dialogLayout.findViewById(R.id.dialog_textView_amount);
                TextView bank = (TextView) dialogLayout.findViewById(R.id.dialog_textView_bank);
                TextView paymentMethod = (TextView) dialogLayout.findViewById(R.id.dialog_textView_payment_method);
                TextView installments = (TextView) dialogLayout.findViewById(R.id.dialog_textView_installments);

                String stringAmount =getResources().getString(R.string.currency)+" "+data.getStringExtra(StepsUtils.AMOUNT);
                amount.setText(stringAmount);
                bank.setText(data.getStringExtra(StepsUtils.CARD_ISSUER_NAME));
                paymentMethod.setText(data.getStringExtra(StepsUtils.PAYMENT_METHOD_NAME));
                installments.setText(data.getStringExtra(StepsUtils.RECOMMENDED_MESSAGE));

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.dialog_title)
                .setView(dialogLayout);

                builder.setPositiveButton(R.string.dialog_button_ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditText editText= (EditText) Step1Activity.this.findViewById(R.id.step1_editText);
                        editText.getText().clear();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }
    }

}
