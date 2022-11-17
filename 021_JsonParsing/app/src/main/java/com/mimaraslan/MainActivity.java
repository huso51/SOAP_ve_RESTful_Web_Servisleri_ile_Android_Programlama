package com.mimaraslan;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {

    //UYGULAMADAKI TUM SABIT DEGERLER
    static final String URL = "http://mimaraslan.com/listeleme.json" ;

    // XML node keys KOK ELEMANLARI
    static final String KAYIT = "item" ;
    static final String ID = "id" ;
    static final String ADI = "name" ;
    static final String MAAS = "salary" ;
    static final String ACIKLAMA = "description" ;

    JSONArray jsonArray = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList <HashMap<String, String>> menuItems = new  ArrayList <HashMap<String, String>>();

        JSONParser parser = new JSONParser();

        JSONObject jsonObject = parser.getJSONFromUrl(URL);

        try {
            //BIR KAYIT item DIZI HALINE GETIRILIYOR
            jsonArray = jsonObject.getJSONArray(KAYIT);

            //JSON DIZISINDEKI ELEMANLAR DONGU ILE BIRER BORER ALINIYOR item:{...}
            for (int i =0; i < jsonArray.length(); i++ ){
                JSONObject kayit = jsonArray.getJSONObject(i);

                String id = kayit.getString(ID);
                String adi = kayit.getString(ADI);
                String maas = kayit.getString(MAAS);
                String aciklama = kayit.getString(ACIKLAMA);

                HashMap<String, String> map = new HashMap<String, String>();

                //COCUK ELEMANLARI HashMap ANAHTAR key => value DEGER ILE BIRLESTIRIYORUZ YAZDIRIYORUZ
                map.put(ID,id );
                map.put(ADI, adi);
                map.put(MAAS, maas);
                map.put(ACIKLAMA, aciklama);

                menuItems.add(map);

            }


        }catch (Exception e){
            e.printStackTrace();
        }



        //menuItems
        ListAdapter adapter = new SimpleAdapter(
                this,
                menuItems,
                R.layout.list_item,
                new String [] {ADI, ACIKLAMA, MAAS},
                new int[] {R.id.adi, R.id.aciklama, R.id.maas}
        );

        setListAdapter(adapter);

        ListView lv = getListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //LISTEDEKI BIR KAYDIN SECILMESI SONUCUNDA KAYDA AIT VERILER ALINIYOR
                String adi = ((TextView)view.findViewById(R.id.adi)).getText().toString();
                String maas = ((TextView)view.findViewById(R.id.maas)).getText().toString();
                String aciklama = ((TextView)view.findViewById(R.id.aciklama)).getText().toString();

                Intent in = new Intent(getApplicationContext(), SingleItemActivity.class);
                in.putExtra(ADI, adi);
                in.putExtra(MAAS, maas);
                in.putExtra(ACIKLAMA, aciklama);
                startActivity(in);

            }
        });



    }
}
