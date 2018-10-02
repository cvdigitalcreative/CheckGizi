package com.digitalcreative.aplikasigizi.Controller.Antropometri;


import android.os.Bundle;

import com.digitalcreative.aplikasigizi.Boundary.Mainmenu.Antro_HasilPengukuran;
import com.digitalcreative.aplikasigizi.Entity.Laki_laki.LK_Data_IMT_umur;
import com.digitalcreative.aplikasigizi.Entity.Laki_laki.LK_Data_PB_BB_0sd24;
import com.digitalcreative.aplikasigizi.Entity.Laki_laki.LK_Data_PB_BB_24sd64;
import com.digitalcreative.aplikasigizi.Entity.Laki_laki.LK_Data_beratBadan_Umur;
import com.digitalcreative.aplikasigizi.Entity.Laki_laki.LK_Data_panjangBadan_Umur;

public class Hitung_SDLakilaki {
    Decision_Antro decision_antro = new Decision_Antro();
    int umur, getIndeks;
    double beratBadan, panjangBadan;

    public Hitung_SDLakilaki(int getUmur, double getberatBadan, double gettinggiBadan) {
        this.umur = getUmur;
        this.beratBadan = getberatBadan;
        this.panjangBadan = gettinggiBadan;
    }


    public String SD_beratBadan_per_Umur(){
        //Invoke DataClass
        LK_Data_beratBadan_Umur LKData_beratBadan_umur =  new LK_Data_beratBadan_Umur();

        //Init
        double[] median = LKData_beratBadan_umur.getBeratBadan_Umur_median();
        double[] negativeSD_1 = LKData_beratBadan_umur.getBeratBadan_Umur_min1SD();
        double[] positiveSD_1 = LKData_beratBadan_umur.getBeratBadan_Umur_pls1SD();

        //Actions
        double hasil_SD_beratBadan_per_Umur = hitung_zScore(umur, beratBadan, median, negativeSD_1, positiveSD_1);

        //Start make a Decision
        return decision_antro.startDecision_Gizi(hasil_SD_beratBadan_per_Umur);
    }




    public String SD_panjangBadan_per_Umur(){
        //Invoke DataClass
        LK_Data_panjangBadan_Umur LKData_panjangBadan_umur =  new LK_Data_panjangBadan_Umur();

        //Init
        double[] median =       LKData_panjangBadan_umur.getPB_Umur_median();
        double[] negativeSD_1 = LKData_panjangBadan_umur.getPB_Umur_min1SD();
        double[] positiveSD_1 = LKData_panjangBadan_umur.getPB_Umur_pls1SD();

        //Actions
        double hasil_SD_panjangBadan_per_Umur = hitung_zScore(umur, panjangBadan, median, negativeSD_1, positiveSD_1);

        //Start make a Decision
        return decision_antro.startDecision_TinggiPendek(hasil_SD_panjangBadan_per_Umur);
    }




    public String SD_IMT_per_Umur(){
        //Invoke Data Class
        LK_Data_IMT_umur LKData_imt_umur =  new LK_Data_IMT_umur();

        //Init
        double[] median =       LKData_imt_umur.getIMT_Umur_median();
        double[] negativeSD_1 = LKData_imt_umur.getIMT_Umur_min1SD();
        double[] positiveSD_1 = LKData_imt_umur.getIMT_Umur_pls1SD();

        //Actions
        //IMT Formula
        double IMT = beratBadan /(Math.pow(panjangBadan/100, 2));

        //go zScore
        double SD_IMT_per_Umur = hitung_zScore(umur, IMT, median, negativeSD_1, positiveSD_1);
        System.out.println("IMT = " +IMT);
        System.out.println("hasil IMT per Umur = " +SD_IMT_per_Umur);

        return decision_antro.startDecision_GemukKurus(IMT);
    }




    public String SD_panjangBadan_per_beratBadan(){
        //Init
        double hasil_SD;
        String finalresult = null;

        //Actions
        if(umur <= 24){
            //Invoke the Class
            LK_Data_PB_BB_0sd24 pbBb0sd24 = new LK_Data_PB_BB_0sd24();

            //Init
            double[] pBadan =       pbBb0sd24.getPanjangBadan();
            double[] median =       pbBb0sd24.getPanjangBadan_Median();
            double[] negativeSD_1 = pbBb0sd24.getPanjangBadan_min1SD();
            double[] positiveSD_1 = pbBb0sd24.getPanjangBadan_pls1SD();

            //Step - get the index
            double depan = (long) panjangBadan;

            for (int i = 0; i < pBadan.length; i++){
                if(depan == (long) pBadan[i]){
                    //checking if value when is < ( .5) and stop, or when is > ( .5), then stop
                    if (panjangBadan < pBadan[i+1]) {
                        getIndeks = i;

                        break;
                    } else {
                        getIndeks = i+1;
                        break;
                    }
                }
            }

            //Formula
            hasil_SD = hitung_zScore(getIndeks, beratBadan, median, negativeSD_1, positiveSD_1);

            //Result
            finalresult = decision_antro.startDecision_GemukKurus(hasil_SD);

        } else if (umur > 24 && umur <= 64) {
            //Invoke the Class
            LK_Data_PB_BB_24sd64 pbBb24sd64 = new LK_Data_PB_BB_24sd64();

            //Init
            double[] pBadan =       pbBb24sd64.getPanjangBadan();
            double[] median =       pbBb24sd64.getPanjangBadan_Median();
            double[] negativeSD_1 = pbBb24sd64.getPanjangBadan_min1SD();
            double[] positiveSD_1 = pbBb24sd64.getPanjangBadan_pls1SD();

            //Step - get the index
            double depan = (long) panjangBadan;
            for (int i = 0; i < pBadan.length; i++){
                if(depan == (long) pBadan[i]){
                    //checking if value when is < ( .5) and stop, or when is > ( .5), then stop
                    if (panjangBadan < pBadan[i+1]) {
                        getIndeks = i;
                        break;
                    } else {
                        getIndeks = i+1;
                        break;
                    }
                }
            }


            //Formula
            hasil_SD = hitung_zScore(getIndeks, beratBadan, median, negativeSD_1, positiveSD_1);

            //Result
            finalresult = decision_antro.startDecision_GemukKurus(hasil_SD);

        } else {
            System.out.println("Umur error");
        }

        return finalresult;
    }


    private double hitung_zScore(int umur, double BB_PB_IMT, double[] median, double[] negativeSD_1, double[] positiveSD_1) {
        //Init
        double hasil;

        //Actions
        //checking when age > or < from median
        double checkSD_positiveOrNegative;
        if (BB_PB_IMT > median[umur]){
            checkSD_positiveOrNegative = positiveSD_1[umur];
        } else if (BB_PB_IMT < median[umur]) {
            checkSD_positiveOrNegative = negativeSD_1[umur];
        } else {
            checkSD_positiveOrNegative = median[umur];
        }

        //Scoring z-score
        hasil = (BB_PB_IMT - median[umur])/(median[umur] - checkSD_positiveOrNegative);
        return hasil;
    }
}
