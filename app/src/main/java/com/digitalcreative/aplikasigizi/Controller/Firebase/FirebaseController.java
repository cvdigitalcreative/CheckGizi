package com.digitalcreative.aplikasigizi.Controller.Firebase;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Display;

import com.digitalcreative.aplikasigizi.Controller.Adapter.Riwayat_RecyclerView;
import com.digitalcreative.aplikasigizi.Model.Model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirebaseController {
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;

    public void savingData(int umur, String getalamat, String getnoHp, String getanake, String getsaudarake, double tinggiBadan,
                           double beratBadan, String getNama, String getPenyakitterakhir, String jenisKelamin,
                           String resultBB_Umur, String resultPB_Umur, String resultIMT_Umur, String resultPB_BB,
                           String getLila, String getHb, String getHBO, String getHBO_polio1, String getHBO_polio2,
                           String getHBO_polio3, String getHBO_polio4, String getCampak){
        //Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseUser =  firebaseAuth.getCurrentUser();

        String riwayatkey= firebaseDatabase.getReference("Data_Kesehatan").child(firebaseUser.getUid()).push().getKey();

        //get time using timeStamp
        Long timeStamp = System.currentTimeMillis()/1000;
        String getTS = timeStamp.toString();

        Date calendar = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
        String df = simpleDateFormat.format(calendar);


        //SavetoFirebase
        myRef = firebaseDatabase.getReference().child("Data_Kesehatan").child(firebaseUser.getUid()).child(df).child(riwayatkey);
        myRef.child("detail_nama").setValue(getNama);
        myRef.child("detail_Tanggal").setValue(getTS);
        myRef.child("detail_jenisKelamin").setValue(jenisKelamin);
        myRef.child("detail_tinggiBadan").setValue(tinggiBadan);
        myRef.child("detail_alamat").setValue(getalamat);
        myRef.child("detail_anakKe").setValue(getanake);
        myRef.child("detail_dariBerapaSaudara").setValue(getsaudarake);
        myRef.child("detail_no_telepon").setValue(getnoHp);
        myRef.child("detail_beratBadan").setValue(beratBadan);
        myRef.child("detail_Umur").setValue(umur);
        myRef.child("detail_penyakitTerakhir").setValue(getPenyakitterakhir);
        myRef.child("detail_Lila").setValue(getLila);
        myRef.child("detail_Hb").setValue(getHb);
        myRef.child("status_gizi_BB_per_Umur").setValue(resultBB_Umur);
        myRef.child("status_gizi_PB_per_Umur").setValue(resultPB_Umur);
        myRef.child("status_gizi_IMT_per_Umur").setValue(resultIMT_Umur);
        myRef.child("status_gizi_PB_per_BB").setValue(resultPB_BB);
        myRef.child("status_ImunisasiHBO").setValue(getHBO);
        myRef.child("status_ImunisasiHBO_Polio1").setValue(getHBO_polio1);
        myRef.child("status_ImunisasiHBO_Polio2").setValue(getHBO_polio2);
        myRef.child("status_ImunisasiHBO_Polio3").setValue(getHBO_polio3);
        myRef.child("status_ImunisasiHBO_Polio4").setValue(getHBO_polio4);
        myRef.child("status_ImunisasiCampak").setValue(getCampak);
    }

    public List<Model> loadData(final List<Model> list, final RecyclerView recyclerView, final Riwayat_RecyclerView riwayat_recyclerView){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseUser =  firebaseAuth.getCurrentUser();
        myRef = firebaseDatabase.getReference("Data_Kesehatan");

        final String user = firebaseUser.getUid();

        myRef.child(user).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                        for(DataSnapshot dataSnapshot2: dataSnapshot1.getChildren()){
                           Model model = new Model();
                                String nama = dataSnapshot2.child("detail_nama").getValue().toString();
                                String umur = dataSnapshot2.child("detail_Umur").getValue().toString();
                                String beratBadan = dataSnapshot2.child("detail_beratBadan").getValue().toString();
                                String panjangBadan = dataSnapshot2.child("detail_tinggiBadan").getValue().toString();
                                String jenisKelamin = dataSnapshot2.child("detail_jenisKelamin").getValue().toString();
                                String Hb = dataSnapshot2.child("detail_Hb").getValue().toString();
                                String Lila = dataSnapshot2.child("detail_Lila").getValue().toString();
                                long milliseconds = Long.parseLong(dataSnapshot2.child("detail_Tanggal").getValue().toString());
                                String anakke = dataSnapshot2.child("detail_anakKe").getValue().toString();
                                String saudarake = dataSnapshot2.child("detail_dariBerapaSaudara").getValue().toString();
                                String notel = dataSnapshot2.child("detail_no_telepon").getValue().toString();
                                String alamat = dataSnapshot2.child("detail_alamat").getValue().toString();
                                String HBO = dataSnapshot2.child("status_ImunisasiHBO").getValue().toString();
                                String HBO_Polio1 = dataSnapshot2.child("status_ImunisasiHBO_Polio1").getValue().toString();
                                String HBO_Polio2 = dataSnapshot2.child("status_ImunisasiHBO_Polio2").getValue().toString();
                                String HBO_Polio3 = dataSnapshot2.child("status_ImunisasiHBO_Polio3").getValue().toString();
                                String HBO_Polio4 = dataSnapshot2.child("status_ImunisasiHBO_Polio4").getValue().toString();
                                String campak = dataSnapshot2.child("status_ImunisasiCampak").getValue().toString();
                                String BB_per_Umur = dataSnapshot2.child("status_gizi_BB_per_Umur").getValue().toString();;
                                String IMT_per_Umur = dataSnapshot2.child("status_gizi_IMT_per_Umur").getValue().toString();;
                                String PB_per_Umur = dataSnapshot2.child("status_gizi_PB_per_Umur").getValue().toString();;
                                String PB_per_BB = dataSnapshot2.child("status_gizi_PB_per_BB").getValue().toString();;

                                Date date = new Date();
                                date.setTime(milliseconds*1000);
                                String tanggal = new SimpleDateFormat("dd").format(date);
                                String bulan = generateMonth(Integer.valueOf(new SimpleDateFormat("MM").format(date)));

                                model.setMilisecs(String.valueOf(milliseconds));
                                model.setAnakke(anakke);
                                model.setAlamat(alamat);
                                model.setSaudarake(saudarake);
                                model.setNotel(notel);
                                model.setNama(nama);
                                model.setUmur(umur);
                                model.setBeratBadan(beratBadan);
                                model.setPanjangBadan(panjangBadan);
                                model.setJenisKelamin(jenisKelamin);
                                model.setTanggal(tanggal);
                                model.setBulan(bulan);
                                model.setHb(Hb);
                                model.setLila(Lila);
                                model.setBB_Umur(BB_per_Umur);
                                model.setIMT_Umur(IMT_per_Umur);
                                model.setPB_Umur(PB_per_Umur);
                                model.setPB_BB(PB_per_BB);
                                model.setStatus_campak(campak);
                                model.setStatus_HBO(HBO);
                                model.setStatus_Polio1(HBO_Polio1);
                                model.setStatus_Polio2(HBO_Polio2);
                                model.setStatus_Polio3(HBO_Polio3);
                                model.setStatus_Polio4(HBO_Polio4);
                                list.add(model);

                                Collections.sort(list, Model.BY_ASC);
                                Collections.reverse(list);
                                recyclerView.setAdapter(riwayat_recyclerView);
                        }
                    }
                }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    return list;
    }

    private String generateMonth(int month) {
        String hasil = null;
        switch (month) {
            case 1:
                hasil = "Jan";
                break;
            case 2:
                hasil = "Feb";
                break;
            case 3:
                hasil = "Mar";
                break;
            case 4:
                hasil = "Apr";
                break;
            case 5:
                hasil = "Mei";
                break;
            case 6:
                hasil = "Jun";
                break;
            case 7:
                hasil = "Jul";
                break;
            case 8:
                hasil = "Ags";
                break;
            case 9:
                hasil = "Sep";
                break;
            case 10:
                hasil = "Okt";
                break;
            case 11:
                hasil = "Nov";
                break;
            case 12:
                hasil = "Des";
                break;
            default:
                System.out.println("Hari Tidak Ditemukan");
                break;
        }
        return hasil;
    }
}
