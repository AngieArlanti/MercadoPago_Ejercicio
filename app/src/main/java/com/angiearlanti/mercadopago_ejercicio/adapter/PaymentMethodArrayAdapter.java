package com.angiearlanti.mercadopago_ejercicio.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.angiearlanti.mercadopago_ejercicio.R;
import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;
import com.angiearlanti.mercadopago_ejercicio.utils.StepsUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Angie on 2/12/2016.
 */
public class PaymentMethodArrayAdapter extends ArrayAdapter<PaymentMethod> {

    private final Activity context;
    private final List<PaymentMethod> objects;

    public PaymentMethodArrayAdapter(Activity context, List<PaymentMethod> objects) {

        super(context, R.layout.list_view_item_step2, objects);
        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_view_item_step2, parent, false);
        LinearLayout layout = (LinearLayout) rowView.findViewById(R.id.step2_item_layout);
        PaymentMethod pm = objects.get(position);

        //if (pm.getPayment_type_id().equals(StepsUtils.PAYMENT_TYPE)){
            String url = pm.getSecure_thumbnail();

            ImageView imageView = (ImageView) rowView.findViewById(R.id.step2_icon);


            Picasso.with(context)
                    .load(url)
                    .into(imageView);

            TextView nameTextView = (TextView)rowView.findViewById(R.id.step2_name);
            nameTextView.setText(pm.getName());

        //}else{
          //  rowView = new Space(context);
            //rowView.setVisibility(View.GONE);
        //}



        return rowView;
    }


}
