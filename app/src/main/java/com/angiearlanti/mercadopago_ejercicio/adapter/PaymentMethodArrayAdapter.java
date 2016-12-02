package com.angiearlanti.mercadopago_ejercicio.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.angiearlanti.mercadopago_ejercicio.R;
import com.angiearlanti.mercadopago_ejercicio.model.PaymentMethod;

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

        /*Pongo la misma imagen para cada producto. Pero tienen que poner
         la imagen correspondiente a cada producto.
          */
        /*ImageView imageView = (ImageView)rowView.findViewById(R.id.icon);
        String nombre_imagen = objects[position].getName();

        int imageId = context.getResources().getIdentifier(nombre_imagen.toLowerCase(Locale.getDefault()),
                "drawable", context.getPackageName());



        imageView.setImageResource(imageId);
*/
        TextView nameTextView = (TextView)rowView.findViewById(R.id.name);
        nameTextView.setText((objects.get(position)).getName());


        return rowView;
    }


}
