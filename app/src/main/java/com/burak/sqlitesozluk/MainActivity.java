package com.burak.sqlitesozluk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dh =new DatabaseHelper(this);

        /*new KelimelerDAO().kelimeEkle(dh,"Cop","Polis");
        new KelimelerDAO().kelimeEkle(dh,"Postman","Postacı");
        new KelimelerDAO().kelimeEkle(dh,"SmartPhone","Akıllı Telefon");
        new KelimelerDAO().kelimeEkle(dh,"Package","Paket");

        new KelimelerDAO().kelimeSil(dh,6);
        new KelimelerDAO().kelimeGuncelle(dh,8,"xxxxxx","xxxxxx");*/

        /*int sonuc = new KelimelerDAO().kayitKontrol(dh);
        Log.w("Veri sayısı", String.valueOf(sonuc));*/

        Kelimeler kelime = new KelimelerDAO().kelimeGetir(dh, 8);
        Log.w("Aranan Kelime=", String.valueOf(
                kelime.getKelime_id())+" - "+kelime.getEnglish()+" - "+kelime.getTurkce());


        ArrayList<Kelimeler> gelenKelimelerListesi = new KelimelerDAO().tumKelimeler(dh);
        ArrayList<Kelimeler> gelenRandomKelimeler = new KelimelerDAO().rastgeleKelimeler(dh, "ne");

        for (Kelimeler k : gelenKelimelerListesi){
            Log.w(String.valueOf(k.getKelime_id()), k.getEnglish()+"-"+k.getTurkce());
        }

        Log.w("Rastgele başlangıç", "----");

        for (Kelimeler k : gelenRandomKelimeler){
            Log.w(String.valueOf(k.getKelime_id()), k.getEnglish()+"-"+k.getTurkce());
        }

    }
}