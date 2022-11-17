package com.mimaraslan;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {

    //UYGULAMADAKI TUM SABIT DEGERLER
    static final String URL = "http://mimaraslan.com/liste.xml" ;

    // XML node keys KOK ELEMANLARI
    static final String KAYIT = "item" ;
    static final String ID = "id" ;
    static final String ADI = "name" ;
    static final String MAAS = "salary" ;
    static final String ACIKLAMA = "description" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList <HashMap<String, String>> menuItems = new  ArrayList <HashMap<String, String>>();

        XMLParser parser = new XMLParser();
        String xmlResult = parser.getXmlFromUrl(URL);
        Document doc = parser.getDomElement(xmlResult);

        NodeList nl = doc.getElementsByTagName(KAYIT);

        //XML'DEKI KOK ELEMANLARIN DONGU ILE BIRER BORER ALIYORUZ <item>...</item>
        for (int i =0; i < nl.getLength(); i++ ){
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);

            //COCUK ELEMANLARI HashMap key => value ILE YAZDIRIYORUZ
            map.put(ID, parser.getValue(e, ID));
            map.put(ADI, parser.getValue(e, ADI));
            map.put(MAAS, parser.getValue(e, MAAS));
            map.put(ACIKLAMA, parser.getValue(e, ACIKLAMA));

            menuItems.add(map);
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
