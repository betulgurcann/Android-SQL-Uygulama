package com.burak.sqlitesozluk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class KelimelerDAO {

    public void kelimeEkle (DatabaseHelper dh, String english, String turkce){
        SQLiteDatabase dbx = dh.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("english",english);
        degerler.put("turkce",turkce);

        dbx.insertOrThrow("kelimeler",null,degerler);
        dbx.close();
    }

    public ArrayList<Kelimeler> tumKelimeler(DatabaseHelper dh){
        ArrayList<Kelimeler> kelimeler = new ArrayList<>();
        SQLiteDatabase dbx = dh.getReadableDatabase();

        Cursor c = dbx.rawQuery("SELECT * FROM kelimeler",null);

        while (c.moveToNext()){
            Kelimeler kelime = new Kelimeler(c.getInt(c.getColumnIndex("kelime_id")),
                    c.getString(c.getColumnIndex("english")),
                    c.getString(c.getColumnIndex("turkce")));

            kelimeler.add(kelime);
        }

        return kelimeler;
    }

    public void kelimeSil(DatabaseHelper dh, int kelime_id){
        SQLiteDatabase dbx = dh.getWritableDatabase();
        dbx.delete("kelimeler", "kelime_id=?",new String[]{String.valueOf(kelime_id)});
        dbx.close();

    }


    public void kelimeGuncelle(DatabaseHelper dh, int kelime_id, String english, String turkce){
        SQLiteDatabase dbx = dh.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("english",english);
        degerler.put("turkce",turkce);

        dbx.update("kelimeler", degerler, "kelime_id=?",new String[]{String.valueOf(kelime_id)});
        dbx.close();
    }

    public int kayitKontrol(DatabaseHelper dh){
        int sonuc = 0;
        SQLiteDatabase dbx = dh.getWritableDatabase();

        Cursor c = dbx.rawQuery("SELECT count(*) as sonuc FROM kelimeler",null);

        while (c.moveToNext()){
            sonuc = c.getInt(c.getColumnIndex("sonuc"));
        }
        return sonuc;
    }

    public Kelimeler kelimeGetir(DatabaseHelper dh, int kelime_id){
        Kelimeler kelime = new Kelimeler();
        SQLiteDatabase dbx = dh.getWritableDatabase();

        Cursor c = dbx.rawQuery("SELECT * FROM kelimeler WHERE kelime_id=" + kelime_id ,null);

        while (c.moveToNext()){
            Kelimeler k = new Kelimeler(c.getInt(c.getColumnIndex("kelime_id")),
                    c.getString(c.getColumnIndex("english")),
                    c.getString(c.getColumnIndex("turkce")));

            kelime = k;
        }

        return kelime;
    }

    public ArrayList<Kelimeler> rastgeleKelimeler(DatabaseHelper dh, String keyword){
        ArrayList<Kelimeler> kelimeler = new ArrayList<>();
        SQLiteDatabase dbx = dh.getReadableDatabase();

        Cursor c = dbx.rawQuery("SELECT * FROM kelimeler WHERE english like'%"+keyword+"%'",null);

        while (c.moveToNext()){
            Kelimeler kelime = new Kelimeler(c.getInt(c.getColumnIndex("kelime_id")),
                    c.getString(c.getColumnIndex("english")),
                    c.getString(c.getColumnIndex("turkce")));

            kelimeler.add(kelime);
        }

        return kelimeler;
    }

}
