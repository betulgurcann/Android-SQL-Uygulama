package com.burak.sqlitesozluk;

public class Kelimeler {
    private int kelime_id;
    private String english;
    private String turkce;

    public Kelimeler() {
    }

    public Kelimeler(int kelime_id, String english, String turkce) {
        this.kelime_id = kelime_id;
        this.english = english;
        this.turkce = turkce;
    }

    public int getKelime_id() {
        return kelime_id;
    }

    public void setKelime_id(int kelime_id) {
        this.kelime_id = kelime_id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getTurkce() {
        return turkce;
    }

    public void setTurkce(String turkce) {
        this.turkce = turkce;
    }
}
