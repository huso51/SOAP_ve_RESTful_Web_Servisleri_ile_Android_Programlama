package com.mimaraslan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SingleItemActivity extends AppCompatActivity {

    // XML node keys KOK ELEMANLARI
    static final String ID = "id" ;
    static final String ADI = "name" ;
    static final String MAAS = "salary" ;
    static final String ACIKLAMA = "description" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item);

        //Intent ILE VERILER ALINIYOR
        Intent in = getIntent();

        //XML VERI DEGERLERI Intent ICERISINDEN ALINIYOR
        String adi = in.getStringExtra(ADI);
        String maas =  in.getStringExtra(MAAS);
        String aciklama =  in.getStringExtra(ACIKLAMA);


        //EKRANDAKI BILESENLER ILE ILETISIME GECILIYOR
        TextView lblAdi =  (TextView)findViewById(R.id.adi);
        TextView lblMaas = (TextView) findViewById(R.id.maas);
        TextView lblAciklama = (TextView) findViewById(R.id.aciklama);

        //ALINAN VERILER BIR BILESNDE EKRANDA GOSTERILIYOR
       lblAdi.setText(adi);
       lblMaas.setText(maas);
        lblAciklama.setText(aciklama);


    }
}
