package com.angiearlanti.mercadopago_ejercicio.utils;

import android.app.Activity;
import android.content.Intent;

import com.angiearlanti.mercadopago_ejercicio.R;
import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angie on 3/12/2016.
 */
public class TaskUtils {

    public static List<PaymentMethod> cleanTypes(List<PaymentMethod> pms) {

        List<PaymentMethod> data =new ArrayList<>();

        for (PaymentMethod pm : pms) {
            if (pm.getPayment_type_id().equals(StepsUtils.PAYMENT_TYPE)) {
                data.add(pm);
            }
        }

        return data;
    }

    private static boolean isValidAmount(String amount, Number min, Number max) {

        Double a = Double.valueOf(amount);
        Double mi = min.doubleValue();
        Double ma = max.doubleValue();


        return (a>=mi) && (a<=ma) ? true:false;
    }

    public static boolean checkPaymentMethodAmount(Activity context, String amount, Number min, Number max) {

        if(!TaskUtils.isValidAmount(amount, min, max)){

            Intent i = context.getIntent();
            String message = context.getResources().getString(R.string.error_message_payment_amount);
            String title = context.getResources().getString(R.string.error_title_invalid_input);
            i.putExtra(StepsUtils.ERROR_MESSAGE,message);
            i.putExtra(StepsUtils.ERROR_TITLE,title);

            context.setResult(context.RESULT_CANCELED, i);
            context.finish();
            return false;

        }
        return true;
    }
}
