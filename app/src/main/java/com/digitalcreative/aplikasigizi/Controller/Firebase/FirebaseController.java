package com.digitalcreative.aplikasigizi.Controller.Firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseController {
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    public void savingData(int umur, double tinggiBadan, double beratBadan, String getNama, String getPenyakitterakhir,
                           String jenisKelamin, String resultBB_Umur, String resultPB_Umur,
                           String resultIMT_Umur, String resultPB_BB, String getLila,
                           String getHb, String getHBO, String getHBO_polio1,
                           String getHBO_polio2, String getHBO_polio3,
                           String getHBO_polio4,
                           String getCampak){
        //Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseUser =  firebaseAuth.getCurrentUser();
        String riwayatkey= firebaseDatabase.getReference("HasilAntro").child(firebaseUser.getUid()).push().getKey();

        //SavetoFirebase
        myRef = firebaseDatabase.getReference().child("Data_Kesehatan").child(firebaseUser.getUid()).child(riwayatkey);
        myRef.child("date_tanggal");
        myRef.child("detail_nama").setValue(getNama);
        myRef.child("detail_jenisKelamin").setValue(jenisKelamin);
        myRef.child("detail_tinggiBadan").setValue(tinggiBadan);
        myRef.child("detail_beratBadan").setValue(beratBadan);
        myRef.child("detail_Umur").setValue(umur);
        myRef.child("detail_penyakitTerakhir").setValue(getPenyakitterakhir);
        myRef.child("detail_Lila").setValue(getLila);
        myRef.child("detail_Hb").setValue(getHb);
        myRef.child("status_Gizi").child("BB_per_Umur").setValue(resultBB_Umur);
        myRef.child("status_Gizi").child("PB_per_Umur").setValue(resultPB_Umur);
        myRef.child("status_Gizi").child("IMT_per_Umur").setValue(resultIMT_Umur);
        myRef.child("status_Gizi").child("PB_per_BB").setValue(resultPB_BB);
        myRef.child("status_Imunisasi").child("HBO").setValue(getHBO);
        myRef.child("status_Imunisasi").child("HBO_Polio1").setValue(getHBO_polio1);
        myRef.child("status_Imunisasi").child("HBO_Polio2").setValue(getHBO_polio2);
        myRef.child("status_Imunisasi").child("HBO_Polio3").setValue(getHBO_polio3);
        myRef.child("status_Imunisasi").child("HBO_Polio4").setValue(getHBO_polio4);
        myRef.child("status_Imunisasi").child("Campak").setValue(getCampak);
    }
}
