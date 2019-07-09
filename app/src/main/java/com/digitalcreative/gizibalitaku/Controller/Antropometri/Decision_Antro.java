package com.digitalcreative.gizibalitaku.Controller.Antropometri;

import com.digitalcreative.gizibalitaku.Entity.Laki_laki.LK_Data_beratBadan_Umur;

public class Decision_Antro {

  public String startDecision_Gizi(double check){
      String result;

        if(check < -3){
            result = "Gizi Buruk";
        } else if(check > -3 && check < -2){
            result = "Gizi Kurang";
        } else if(check > -2 && check < 2){
            result = "Gizi Baik";
        } else{
            result = "Gizi Lebih";
        }
      return result;
  }

    public String startDecision_TinggiPendek(double check){
        String result;

        if(check < -3){
            result = "Sangat Pendek";
        } else if(check > -3 && check < -2){
            result = "Pendek";
        } else if(check > -2 && check < 2){
            result = "Normal";
        } else{
            result = "Tinggi";
        }
        return result;
    }

    public String startDecision_GemukKurus(double check){
        String result;

        if(check < -3){
            result = "Sangat Kurus";
        } else if(check > -3 && check < -2){
            result = "Kurus";
        } else if(check > -2 && check < 2){
            result = "Normal";
        } else{
            result = "Gemuk";
        }
        return result;
    }
}
