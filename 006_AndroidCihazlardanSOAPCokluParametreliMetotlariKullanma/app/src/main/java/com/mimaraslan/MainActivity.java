package com.mimaraslan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


    private final String URL = "http://10.0.2.2:8085/A004_SOAPSunucusu/services/SelamWS?wsdl";
    private final String NAMESPACE = "http://mimaraslan.com";

    private final String METHOD_ADI1 = "selamVer";
    private final String SOAP_OLAYI1 = NAMESPACE+"/"+METHOD_ADI1;

    private final String METHOD_ADI2 = "selamVerIkiParametreli";
    private final String SOAP_OLAYI2 = NAMESPACE+"/"+METHOD_ADI2;

    private final String METHOD_ADI3 = "selamVerUcParametreli";
    private final String SOAP_OLAYI3 = NAMESPACE+"/"+METHOD_ADI3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SoapObject request_istek = new SoapObject(NAMESPACE, METHOD_ADI1);

        PropertyInfo adiSoyadiOzellikBilgisi = new PropertyInfo();
        adiSoyadiOzellikBilgisi.setName("adiSoyadi");
        adiSoyadiOzellikBilgisi.setType(String.class);
        adiSoyadiOzellikBilgisi.setValue("Sinan Şen");

        request_istek.addProperty(adiSoyadiOzellikBilgisi);


        SoapSerializationEnvelope zarf = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        zarf.setOutputSoapObject(request_istek);


        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            androidHttpTransport.call(SOAP_OLAYI1, zarf);
            SoapPrimitive response_gelenCevap = (SoapPrimitive) zarf.getResponse();

            TextView textView = (TextView) findViewById(R.id.textView1);
            textView.setText(response_gelenCevap.toString());




        }catch (IOException e) {
            System.out.println("HATA: "+ e);
            e.printStackTrace();
        }catch (XmlPullParserException e) {
            System.out.println("HATA: "+ e);
            e.printStackTrace();
        }




        request_istek = new SoapObject(NAMESPACE, METHOD_ADI2);



        PropertyInfo unvaniOzellikBilgisi = new PropertyInfo();
        unvaniOzellikBilgisi.setName("unvani");
        unvaniOzellikBilgisi.setType(String.class);
        unvaniOzellikBilgisi.setValue("Yazılımcı");
        request_istek.addProperty(unvaniOzellikBilgisi);


        adiSoyadiOzellikBilgisi = new PropertyInfo();
        adiSoyadiOzellikBilgisi.setName("adiSoyadi");
        adiSoyadiOzellikBilgisi.setType(String.class);
        adiSoyadiOzellikBilgisi.setValue("Sinan Şen");
        request_istek.addProperty(adiSoyadiOzellikBilgisi);






        zarf = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        zarf.setOutputSoapObject(request_istek);


        androidHttpTransport = new HttpTransportSE(URL);

        try {
            androidHttpTransport.call(SOAP_OLAYI3, zarf);
            SoapPrimitive response_gelenCevap = (SoapPrimitive) zarf.getResponse();


            TextView textView2 = (TextView) findViewById(R.id.textView2);
            textView2.setText(response_gelenCevap.toString());



        }catch (IOException e) {
            System.out.println("HATA: "+ e);
            e.printStackTrace();
        }catch (XmlPullParserException e) {
            System.out.println("HATA: "+ e);
            e.printStackTrace();
        }




        //------------------------------------------

        request_istek = new SoapObject(NAMESPACE, METHOD_ADI3);



        unvaniOzellikBilgisi = new PropertyInfo();
        unvaniOzellikBilgisi.setName("unvani");
        unvaniOzellikBilgisi.setType(String.class);
        unvaniOzellikBilgisi.setValue("Yazılımcı");
        request_istek.addProperty(unvaniOzellikBilgisi);


        adiSoyadiOzellikBilgisi = new PropertyInfo();
        adiSoyadiOzellikBilgisi.setName("adiSoyadi");
        adiSoyadiOzellikBilgisi.setType(String.class);
        adiSoyadiOzellikBilgisi.setValue("Sinan Şen");
        request_istek.addProperty(adiSoyadiOzellikBilgisi);

        PropertyInfo yasiOzellikBilgisi = new PropertyInfo();
        yasiOzellikBilgisi.setName("yasi");
        yasiOzellikBilgisi.setType(String.class);
        yasiOzellikBilgisi.setValue(33);
        request_istek.addProperty(yasiOzellikBilgisi);

        zarf = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        zarf.setOutputSoapObject(request_istek);


        androidHttpTransport = new HttpTransportSE(URL);

        try {
            androidHttpTransport.call(SOAP_OLAYI2, zarf);
            SoapPrimitive response_gelenCevap = (SoapPrimitive) zarf.getResponse();


            TextView textView3 = (TextView) findViewById(R.id.textView3);
            textView3.setText(response_gelenCevap.toString());



        }catch (IOException e) {
            System.out.println("HATA: "+ e);
            e.printStackTrace();
        }catch (XmlPullParserException e) {
            System.out.println("HATA: "+ e);
            e.printStackTrace();
        }







    }



}
