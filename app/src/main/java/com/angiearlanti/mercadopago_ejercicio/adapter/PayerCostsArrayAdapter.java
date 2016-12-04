package com.angiearlanti.mercadopago_ejercicio.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.angiearlanti.mercadopago_ejercicio.R;
import com.angiearlanti.mercadopago_ejercicio.model.CardIssuer;
import com.angiearlanti.mercadopago_ejercicio.model.PayerCost;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Angie on 4/12/2016.
 */

public class PayerCostsArrayAdapter extends ArrayAdapter<PayerCost> {

    private Activity context;
    private List<PayerCost> objects;

    public PayerCostsArrayAdapter(Activity context, List<PayerCost> objects) {
        super(context, R.layout.list_view_item_step4, objects);
        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_view_item_step4, parent, false);

        PayerCost payerCost = objects.get(position);


        TextView nameTextView = (TextView)rowView.findViewById(R.id.step4_recommended_message);
        nameTextView.setText(payerCost.getRecommended_message());



        return rowView;
    }




}
