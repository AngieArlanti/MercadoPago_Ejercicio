package com.angiearlanti.mercadopago_ejercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.angiearlanti.mercadopago_ejercicio.Utils.StepsUtils;

import java.math.BigDecimal;

public class Step1Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1);

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

                //TODO: show alert with selected values in next steps
            }
        }
    }

}
