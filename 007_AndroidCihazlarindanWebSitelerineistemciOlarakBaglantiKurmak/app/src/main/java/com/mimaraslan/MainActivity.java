package com.mimaraslan;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button topla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topla = (Button) findViewById(R.id.hesapla);
        topla.setOnClickListener((View.OnClickListener) this);






    }


    private  StringBuilder inputStreamToString (InputStream is){

        return null;
    }

    @Override
    public void onClick(View v) {

        if (v == topla){




            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://10.0.2.2/android_baglantisi/hesapla.php");
            // http://10.0.2.2/android_baglantisi/deneme.php
            try{
                EditText sayi1 = (EditText) findViewById(R.id.etSayi1);
                EditText sayi2 = (EditText) findViewById(R.id.etSayi2);

                String sayi_1 = sayi1.getText().toString();
                String sayi_2 = sayi2.getText().toString();


                List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>(2);
                nameValuePairList.add(new BasicNameValuePair("sayi1", sayi_1));
                nameValuePairList.add(new BasicNameValuePair("sayi2", sayi_2));
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
                HttpResponse response = httpClient.execute(httpPost);

                String gelenSonuc = EntityUtils.toString(response.getEntity());

                //inputStreamToString(response.getEntity().getContent().toString());

                TextView tv = (TextView) findViewById(R.id.txtSonuc);
                tv.setText(gelenSonuc);


                // HttpResponse response = httpClient.execute(httpPost);
                // final String sonuc = EntityUtils.toString(response.getEntity());

                // TextView tv = (TextView) findViewById(R.id.txtSayi1);
                // tv.setText(sonuc);

            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
