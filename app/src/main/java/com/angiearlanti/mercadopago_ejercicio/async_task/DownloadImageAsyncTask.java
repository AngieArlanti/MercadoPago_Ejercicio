package com.angiearlanti.mercadopago_ejercicio.async_task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Angie on 2/12/2016.
 */
public class DownloadImageAsyncTask extends AsyncTask<String, Void, Bitmap> {

    //private ProgressDialog pDialog;
    private ImageView imageView;
    private Activity context;

    public DownloadImageAsyncTask(ImageView imageView){
        this.imageView = imageView;
        this.context = context;
    }



    @Override
    protected void onPreExecute() {
        /*super.onPreExecute();
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading Image ....");
        pDialog.show();*/
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        String url = params[0];

        try {
            return downloadImage(url);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap result) {


        if(result != null){
            /*int height = (Screenwidth*imageView.getHeight())/imageView.getWidth();
            Bitmap pq=Bitmap.createScaledBitmap(result,Screenwidth,height, true);*/
            imageView.setImageBitmap(result);
            //pDialog.dismiss();
        } else {
            //pDialog.dismiss();
            //Toast.makeText(MainActivity.this, getResources().getString(R.string.image_error), Toast.LENGTH_LONG).show();
        }
    }

    private Bitmap downloadImage(String url){
        Bitmap bmp =null;
        try{
            URL ulrn = new URL(url);
            HttpURLConnection con = (HttpURLConnection)ulrn.openConnection();
            InputStream is = con.getInputStream();
            bmp = BitmapFactory.decodeStream(is);
            if (bmp != null)
                return bmp;

        }catch(Exception e){
            e.printStackTrace();
        }
        return bmp;
    }
}
