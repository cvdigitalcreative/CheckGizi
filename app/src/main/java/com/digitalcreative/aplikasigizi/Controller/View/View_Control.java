package com.digitalcreative.aplikasigizi.Controller.View;

import android.os.Bundle;

import com.digitalcreative.aplikasigizi.Boundary.Mainmenu.Antro_HasilPengukuran;
import com.digitalcreative.aplikasigizi.Controller.Antropometri.Hitung_SDLakilaki;
import com.digitalcreative.aplikasigizi.Controller.Antropometri.Hitung_SDPerempuan;
import com.digitalcreative.aplikasigizi.Controller.Firebase.FirebaseController;

public class View_Control {
    Hitung_SDLakilaki hitung_sdLakilaki;
    Hitung_SDPerempuan hitung_sdPerempuan;
    FirebaseController firebaseController;

    String resultBB_Umur, resultPB_Umur, resultIMT_Umur, resultPB_BB,
            getPenyakitterakhir, getNama, getalamat, getnoHp, getanake, getsaudarake,
            JenisKelamin, getpenyakitTerakhir,
            getLila, getHb, getHBO, getHBO_polio1, getHBO_polio2,
            getHBO_polio3, getHBO_polio4, getCampak;

    int umur;
    double tinggiBadan, beratBadan;

    public View_Control(String getUmur, String getalamat, String getnoHp, String getanake, String getsaudarake, String getberatBadan,
                        String gettinggiBadan, String getjenisKelamin, String getnamaAnak, String getpenyakitTerakhir,
                        String getLila, String getHb, String getHBO, String getHBO_polio1, String getHBO_polio2,
                        String getHBO_polio3, String getHBO_polio4, String getCampak) {
        this.umur = Integer.valueOf(getUmur);
        this.getalamat = getalamat;
        this.getnoHp = getnoHp;
        this.getanake = getanake;
        this.getsaudarake = getsaudarake;
        this.beratBadan = Double.valueOf(getberatBadan);
        this.tinggiBadan = Double.valueOf(gettinggiBadan);
        this.JenisKelamin = getjenisKelamin;
        this.getNama = getnamaAnak;
        this.getpenyakitTerakhir = getpenyakitTerakhir;
        this.getLila = getLila;
        this.getHb = getHb;
        this.getHBO = getHBO;
        this.getHBO_polio1 = getHBO_polio1;
        this.getHBO_polio2 = getHBO_polio2;
        this.getHBO_polio3 = getHBO_polio3;
        this.getHBO_polio4 = getHBO_polio4;
        this.getCampak = getCampak;
    }


    public void getData(Antro_HasilPengukuran antro_hasilPengukuran){
        if(JenisKelamin.contains("Laki-laki")){
            hitung_sdLakilaki =  new Hitung_SDLakilaki(umur, beratBadan, tinggiBadan);

            resultBB_Umur = hitung_sdLakilaki.SD_beratBadan_per_Umur();
            resultPB_Umur = hitung_sdLakilaki.SD_panjangBadan_per_Umur();
            resultIMT_Umur = hitung_sdLakilaki.SD_IMT_per_Umur();
            resultPB_BB = hitung_sdLakilaki.SD_panjangBadan_per_beratBadan();

            Bundle bundle =  new Bundle();
            bundle.putString("HBO", getHBO);
            bundle.putString("Polio1", getHBO_polio1);
            bundle.putString("Polio2", getHBO_polio2);
            bundle.putString("Polio3", getHBO_polio3);
            bundle.putString("Polio4", getHBO_polio4);
            bundle.putString("campak", getCampak);
            bundle.putString("test", resultBB_Umur);
            bundle.putString("PBperUmur", resultPB_Umur);
            bundle.putString("IMTperUmur", resultIMT_Umur);
            bundle.putString("BBperBB", resultPB_BB);
            bundle.putString("nama_informasi", getNama);
            bundle.putString("jeniskelamin_informasi", JenisKelamin);
            bundle.putString("umur", String.valueOf(umur));
            bundle.putString("beratbadan", String.valueOf(beratBadan));
            bundle.putString("panjangbadan", String.valueOf(tinggiBadan));
            bundle.putString("lila", getLila);
            bundle.putString("HB", getHb);
            bundle.putString("penyakitTerakhir", getpenyakitTerakhir);
            antro_hasilPengukuran.setArguments(bundle);

        } else {
            hitung_sdPerempuan =  new Hitung_SDPerempuan(umur, beratBadan, tinggiBadan);

            resultBB_Umur = hitung_sdPerempuan.SD_beratBadan_per_Umur();
            resultPB_Umur = hitung_sdPerempuan.SD_panjangBadan_per_Umur();
            resultIMT_Umur = hitung_sdPerempuan.SD_IMT_per_Umur();
            resultPB_BB = hitung_sdPerempuan.SD_panjangBadan_per_beratBadan();

            Bundle bundle =  new Bundle();
            bundle.putString("HBO", getHBO);
            bundle.putString("Polio1", getHBO_polio1);
            bundle.putString("Polio2", getHBO_polio2);
            bundle.putString("Polio3", getHBO_polio3);
            bundle.putString("Polio4", getHBO_polio4);
            bundle.putString("campak", getCampak);
            bundle.putString("test", resultBB_Umur);
            bundle.putString("PBperUmur", resultPB_Umur);
            bundle.putString("IMTperUmur", resultIMT_Umur);
            bundle.putString("BBperBB", resultPB_BB);
            bundle.putString("nama_informasi", getNama);
            bundle.putString("jeniskelamin_informasi", JenisKelamin);
            bundle.putString("umur", String.valueOf(umur));
            bundle.putString("beratbadan", String.valueOf(beratBadan));
            bundle.putString("panjangbadan", String.valueOf(tinggiBadan));
            bundle.putString("lila", getLila);
            bundle.putString("HB", getHb);
            bundle.putString("penyakitTerakhir", getpenyakitTerakhir);

            antro_hasilPengukuran.setArguments(bundle);
        }
    }

    public void saveToFirebase(){
        //get Detail
        System.out.println("masuk sini");
        firebaseController =  new FirebaseController();
        firebaseController.savingData(umur, getalamat, getnoHp, getanake, getsaudarake, tinggiBadan, beratBadan, getNama, getPenyakitterakhir,
                JenisKelamin, resultBB_Umur, resultPB_Umur, resultIMT_Umur, resultPB_BB, getLila, getHb,
                getHBO, getHBO_polio1, getHBO_polio2, getHBO_polio3, getHBO_polio4, getCampak);
    }
}
