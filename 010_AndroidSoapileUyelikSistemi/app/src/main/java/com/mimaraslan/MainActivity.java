package com.mimaraslan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    private final String URL = "http://10.0.2.2:8085/A008_SOAPVeritabaniBaglantisi/services/VeritabaniWS?wsdl";
    private final String NAMESPACE = "http://mimaraslan.com";
    private final String METHOD_NAME = "";
    private final String SOAP_ACTION = NAMESPACE + METHOD_NAME;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLUyeGirisBaglantisi = (Button) findViewById(R.id.button1);
        btnLUyeGirisBaglantisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uyeGirisBaglantisiniDenetle();
            }
        });


        Button btnUyeEkle = (Button) findViewById(R.id.button2);
        btnUyeEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yeniUyeEkle();
            }
        });
    }

    private void uyeGirisBaglantisiniDenetle() {

        EditText uyeKullaniciAdi = (EditText) findViewById(R.id.editText1);
        EditText uyeParola = (EditText) findViewById(R.id.editText2);

        try {
            SoapObject request = new SoapObject(NAMESPACE, "uyeGirisKontroluYap");

            PropertyInfo uyeKullaniciAdiProperty = new PropertyInfo();
            uyeKullaniciAdiProperty.setName("uyeKullaniciAdiParametre");
            uyeKullaniciAdiProperty.setType(String.class);
            uyeKullaniciAdiProperty.setValue(uyeKullaniciAdi.getText().toString());
            request.addProperty(uyeKullaniciAdiProperty);


            PropertyInfo uyeParolaProperty = new PropertyInfo();
            uyeParolaProperty.setName("uyeParolaParametre");
            uyeParolaProperty.setType(String.class);
            uyeParolaProperty.setValue(uyeParola.getText().toString());
            request.addProperty(uyeParolaProperty);


            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION, envelope);

            SoapPrimitive soapPrimitive = (SoapPrimitive) envelope.getResponse();

            TextView tvSonuc = (TextView) findViewById(R.id.textView1);
            tvSonuc.setText(soapPrimitive.toString());



        }catch (IOException e) {
            System.out.println("HATA: "+ e);
            e.printStackTrace();
        }catch (XmlPullParserException e) {
            System.out.println("HATA: "+ e);
            e.printStackTrace();
        }

    }





    private void yeniUyeEkle() {

        EditText uyeKullaniciAdi = (EditText) findViewById(R.id.editText1);
        EditText uyeParola = (EditText) findViewById(R.id.editText2);

        try {
            SoapObject request = new SoapObject(NAMESPACE, "uyeKayitEkle");

            PropertyInfo uyeKullaniciAdiProperty = new PropertyInfo();
            uyeKullaniciAdiProperty.setName("uyeKullaniciAdiParametre");
            uyeKullaniciAdiProperty.setType(String.class);
            uyeKullaniciAdiProperty.setValue(uyeKullaniciAdi.getText().toString());
            request.addProperty(uyeKullaniciAdiProperty);


            PropertyInfo uyeParolaProperty = new PropertyInfo();
            uyeParolaProperty.setName("uyeParolaParametre");
            uyeParolaProperty.setType(String.class);
            uyeParolaProperty.setValue(uyeParola.getText().toString());
            request.addProperty(uyeParolaProperty);


            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION, envelope);

            SoapPrimitive soapPrimitive = (SoapPrimitive) envelope.getResponse();

            TextView tvSonuc = (TextView) findViewById(R.id.textView1);
            tvSonuc.setText(soapPrimitive.toString());

            uyeKullaniciAdi.setText("");
            uyeParola.setText("");

        }catch (IOException e) {
            System.out.println("HATA: "+ e);
            e.printStackTrace();
        }catch (XmlPullParserException e) {
            System.out.println("HATA: "+ e);
            e.printStackTrace();
        }

    }

}
