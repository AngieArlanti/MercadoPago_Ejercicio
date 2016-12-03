package com.angiearlanti.mercadopago_ejercicio.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.angiearlanti.mercadopago_ejercicio.R;
import com.angiearlanti.mercadopago_ejercicio.model.CardIssuer;
import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Angie on 3/12/2016.
 */
public class CardIssuerArrayAdapter extends ArrayAdapter<CardIssuer>{

    private Activity context;
    private List<CardIssuer> objects;

    public CardIssuerArrayAdapter(Activity context, List<CardIssuer> objects) {
        super(context, R.layout.list_view_item_step3, objects);
        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_view_item_step3, parent, false);

        CardIssuer ci = objects.get(position);

        //if (pm.getPayment_type_id().equals(StepsUtils.PAYMENT_TYPE)){
        String url = ci.getSecure_thumbnail();

        ImageView imageView = (ImageView) rowView.findViewById(R.id.step3_icon);


        Picasso.with(context)
                .load(url)
                .into(imageView);

        TextView nameTextView = (TextView)rowView.findViewById(R.id.step3_name);
        nameTextView.setText(ci.getName());





        return rowView;
    }




}
