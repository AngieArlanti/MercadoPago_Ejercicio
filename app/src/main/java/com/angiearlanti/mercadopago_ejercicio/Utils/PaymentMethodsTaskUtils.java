package com.angiearlanti.mercadopago_ejercicio.utils;

import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angie on 3/12/2016.
 */
public class PaymentMethodsTaskUtils {

    public static List<PaymentMethod> cleanTypes(List<PaymentMethod> pms) {

        List<PaymentMethod> data =new ArrayList<>();

        for (PaymentMethod pm : pms) {
            if (pm.getPayment_type_id().equals(StepsUtils.PAYMENT_TYPE)) {
                data.add(pm);
            }
        }

        return data;
    }

}
