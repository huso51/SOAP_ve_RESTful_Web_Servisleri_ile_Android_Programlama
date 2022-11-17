package com.mimaraslan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private final String METHOD_NAME = "personelVerileriniGetir";
    private final String SOAP_ACTION = NAMESPACE +"/"+ METHOD_NAME;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView1 = (TextView) findViewById(R.id.textView1);
        try {
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
            //envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION, envelope);
            Object result = envelope.getResponse();

            SoapPrimitive response = (SoapPrimitive) result;
            String gelenSonuc = response.toString();
            String resultArray[] = gelenSonuc.split("&");

           // TextView textView = new TextView(this);
            String kayitlar = "";
            for (int i = 0; i < resultArray.length; i++) {
             //   textView.append(resultArray[i] + "\n\n");
                kayitlar = kayitlar + resultArray[i] + "\n\n";
            }

           // setContentView(textView);

            textView1.setText(kayitlar);




        }catch (IOException e) {
            System.out.println("HATA: "+ e);
            e.printStackTrace();
        }catch (XmlPullParserException e) {
            System.out.println("HATA: "+ e);
            e.printStackTrace();
        }





    }
}
