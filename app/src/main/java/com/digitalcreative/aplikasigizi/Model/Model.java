package com.digitalcreative.aplikasigizi.Model;

import java.util.Comparator;

public class Model {
    String milisecs;
    String nama;
    String alamat;
    String anakke;
    String saudarake;
    String notel;
    String tanggal;
    String bulan;
    String Umur;
    String jenisKelamin;
    String beratBadan;;
    String panjangBadan;
    String Hb;
    String Lila;
    String status_campak;
    String status_HBO;
    String status_Polio1;
    String status_Polio2;
    String status_Polio3;
    String status_Polio4;
    String BB_Umur;
    String PB_Umur;
    String IMT_Umur;
    String PB_BB;

    public static final Comparator<Model> BY_ASC =  new Comparator<Model>() {
        @Override
        public int compare(Model o1, Model o2) {

            return o1.milisecs.compareTo(o2.milisecs);
        }
    };

    public void setMilisecs(String milisecs) {
        this.milisecs = milisecs;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAnakke() {
        return anakke;
    }

    public void setAnakke(String anakke) {
        this.anakke = anakke;
    }

    public String getSaudarake() {
        return saudarake;
    }

    public void setSaudarake(String saudarake) {
        this.saudarake = saudarake;
    }

    public String getNotel() {
        return notel;
    }

    public void setNotel(String notel) {
        this.notel = notel;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getUmur() {
        return Umur;
    }

    public void setUmur(String umur) {
        Umur = umur;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(String beratBadan) {
        this.beratBadan = beratBadan;
    }

    public String getPanjangBadan() {
        return panjangBadan;
    }

    public void setPanjangBadan(String panjangBadan) {
        this.panjangBadan = panjangBadan;
    }

    public String getHb() {
        return Hb;
    }

    public void setHb(String hb) {
        Hb = hb;
    }

    public String getLila() {
        return Lila;
    }

    public void setLila(String lila) {
        Lila = lila;
    }

    public String getStatus_campak() {
        return status_campak;
    }

    public void setStatus_campak(String status_campak) {
        this.status_campak = status_campak;
    }

    public String getStatus_HBO() {
        return status_HBO;
    }

    public void setStatus_HBO(String status_HBO) {
        this.status_HBO = status_HBO;
    }

    public String getStatus_Polio1() {
        return status_Polio1;
    }

    public void setStatus_Polio1(String status_Polio1) {
        this.status_Polio1 = status_Polio1;
    }

    public String getStatus_Polio2() {
        return status_Polio2;
    }

    public void setStatus_Polio2(String status_Polio2) {
        this.status_Polio2 = status_Polio2;
    }

    public String getStatus_Polio3() {
        return status_Polio3;
    }

    public void setStatus_Polio3(String status_Polio3) {
        this.status_Polio3 = status_Polio3;
    }

    public String getStatus_Polio4() {
        return status_Polio4;
    }

    public void setStatus_Polio4(String status_Polio4) {
        this.status_Polio4 = status_Polio4;
    }

    public String getBB_Umur() {
        return BB_Umur;
    }

    public void setBB_Umur(String BB_Umur) {
        this.BB_Umur = BB_Umur;
    }

    public String getPB_Umur() {
        return PB_Umur;
    }

    public void setPB_Umur(String PB_Umur) {
        this.PB_Umur = PB_Umur;
    }

    public String getIMT_Umur() {
        return IMT_Umur;
    }

    public void setIMT_Umur(String IMT_Umur) {
        this.IMT_Umur = IMT_Umur;
    }

    public String getPB_BB() {
        return PB_BB;
    }

    public void setPB_BB(String PB_BB) {
        this.PB_BB = PB_BB;
    }
}
