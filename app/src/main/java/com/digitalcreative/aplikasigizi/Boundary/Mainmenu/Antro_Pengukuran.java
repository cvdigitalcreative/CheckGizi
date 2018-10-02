package com.digitalcreative.aplikasigizi.Boundary.Mainmenu;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.digitalcreative.aplikasigizi.Controller.View.View_Control;
import com.digitalcreative.aplikasigizi.R;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class Antro_Pengukuran extends Fragment {
    View_Control view_control;
    Antro_HasilPengukuran antro_hasilPengukuran;
    EditText namaAnak, jeniKelamin, beratBadan, tinggiBadan, penyakitTerakhir, umur, lila, hb;
    String getnamaAnak, getjenisKelamin, getberatBadan, gettinggiBadan, getpenyakitTerakhir,
            getUmur, getLila, getHb, getHBO, getHBO_polio1, getHBO_polio2,
            getHBO_polio3, getHBO_polio4, getCampak;
    Button hitungAntro, hbo, polio1, campak, polio2, polio3, polio4, jk_lelaki, jk_Perempuan;

    public Antro_Pengukuran() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pengukuran_antro, container, false);

        //init
        descTheComponent(view);

        //Actions
        actionsStatImunisasi();

        hitungAntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do IT the data
                getTheValue();
                antro_hasilPengukuran =  new Antro_HasilPengukuran();

                view_control =  new View_Control(getUmur, getberatBadan, gettinggiBadan, getjenisKelamin,
                        getnamaAnak, getpenyakitTerakhir, getLila, getHb, getHBO, getHBO_polio1, getHBO_polio2,
                        getHBO_polio3, getHBO_polio4, getCampak);
                view_control.getData(antro_hasilPengukuran);
                view_control.saveToFirebase();

                //show The result
                redirectfragment();
            }
        });
        return view;
    }

    private void getTheValue() {
        //get String Section
        getnamaAnak = namaAnak.getText().toString();
        getjenisKelamin = jeniKelamin.getText().toString();
        getberatBadan = beratBadan.getText().toString();
        gettinggiBadan = tinggiBadan.getText().toString();
        getpenyakitTerakhir = penyakitTerakhir.getText().toString();
        getUmur = umur.getText().toString();
        getLila = lila.getText().toString();
        getHb = hb.getText().toString();
    }

    private void descTheComponent(View view) {
        //EditText Section
        namaAnak = view.findViewById(R.id.ap_input_nama_anak);
        beratBadan = view.findViewById(R.id.ap_input_berat_badan);
        tinggiBadan = view.findViewById(R.id.ap_input_tinggi_badan);
        penyakitTerakhir = view.findViewById(R.id.ap_input_riwayat_penyakit);
        umur = view.findViewById(R.id.ap_input_umur);
        lila = view.findViewById(R.id.ap_input_lila);
        hb = view.findViewById(R.id.ap_input_Hb);

        //Button Section
        hitungAntro = view.findViewById(R.id.btn_hitung_antropometri);
        hbo = view.findViewById(R.id.ap_button_Hbo);
        polio1 = view.findViewById(R.id.ap_button_polio1);
        polio2 = view.findViewById(R.id.ap_button_polio2);
        polio3 = view.findViewById(R.id.ap_button_polio3);
        polio4 = view.findViewById(R.id.ap_button_polio4);
        campak = view.findViewById(R.id.ap_button_campak);
        jk_lelaki = view.findViewById(R.id.ap_JK_lelaki);
        jk_Perempuan= view.findViewById(R.id.ap_JK_perempuan);
    }

    private void actionsStatImunisasi() {
        jk_lelaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jk_lelaki.setTypeface(Typeface.DEFAULT_BOLD);
                jk_Perempuan.setTypeface(Typeface.DEFAULT);

                jk_lelaki.setSelected(true);
                jk_Perempuan.setSelected(false);

                getjenisKelamin = "Perempuan";
            }
        });

        jk_Perempuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jk_lelaki.setTypeface(Typeface.DEFAULT);
                jk_Perempuan.setTypeface(Typeface.DEFAULT_BOLD);

                jk_lelaki.setSelected(false);
                jk_Perempuan.setSelected(true);

                getjenisKelamin = "Laki-laki";
            }
        });

            hbo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean check = true;
                    hbo.setTypeface(Typeface.DEFAULT_BOLD);

                    if (!check){
                        hbo.setSelected(!check);
                    } else {
                        hbo.setSelected(check);
                    }
                    //polio1.setSelected(false);
//                polio2.setSelected(false);
//                polio3.setSelected(false);
//                polio4.setSelected(false);
//                campak.setSelected(false);
                }
            });

        polio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                polio1.setTypeface(Typeface.DEFAULT_BOLD);
                hbo.setTypeface(Typeface.DEFAULT);
                polio2.setTypeface(Typeface.DEFAULT);
                polio3.setTypeface(Typeface.DEFAULT);
                polio4.setTypeface(Typeface.DEFAULT);
                campak.setTypeface(Typeface.DEFAULT);

                hbo.setSelected(false);
                polio1.setSelected(true);
                polio2.setSelected(false);
                polio3.setSelected(false);
                polio4.setSelected(false);
                campak.setSelected(false);
            }
        });

        polio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                polio2.setTypeface(Typeface.DEFAULT_BOLD);
                hbo.setTypeface(Typeface.DEFAULT);
                polio1.setTypeface(Typeface.DEFAULT);
                polio3.setTypeface(Typeface.DEFAULT);
                polio4.setTypeface(Typeface.DEFAULT);
                campak.setTypeface(Typeface.DEFAULT);

                hbo.setSelected(false);
                polio1.setSelected(false);
                polio2.setSelected(true);
                polio3.setSelected(false);
                polio4.setSelected(false);
                campak.setSelected(false);
            }
        });

        polio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                polio3.setTypeface(Typeface.DEFAULT_BOLD);
                hbo.setTypeface(Typeface.DEFAULT);
                polio2.setTypeface(Typeface.DEFAULT);
                polio1.setTypeface(Typeface.DEFAULT);
                polio4.setTypeface(Typeface.DEFAULT);
                campak.setTypeface(Typeface.DEFAULT);

                hbo.setSelected(false);
                polio1.setSelected(false);
                polio2.setSelected(false);
                polio3.setSelected(true);
                polio4.setSelected(false);
                campak.setSelected(false);
            }
        });

        polio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                polio4.setTypeface(Typeface.DEFAULT_BOLD);
                hbo.setTypeface(Typeface.DEFAULT);
                polio2.setTypeface(Typeface.DEFAULT);
                polio3.setTypeface(Typeface.DEFAULT);
                polio1.setTypeface(Typeface.DEFAULT);
                campak.setTypeface(Typeface.DEFAULT);

                hbo.setSelected(false);
                polio1.setSelected(false);
                polio2.setSelected(false);
                polio3.setSelected(false);
                polio4.setSelected(true);
                campak.setSelected(false);
            }
        });

        campak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campak.setTypeface(Typeface.DEFAULT_BOLD);
                hbo.setTypeface(Typeface.DEFAULT);
                polio2.setTypeface(Typeface.DEFAULT);
                polio3.setTypeface(Typeface.DEFAULT);
                polio1.setTypeface(Typeface.DEFAULT);
                polio4.setTypeface(Typeface.DEFAULT);

                hbo.setSelected(false);
                polio1.setSelected(false);
                polio2.setSelected(false);
                polio3.setSelected(false);
                polio4.setSelected(false);
                campak.setSelected(true);
            }
        });
    }

    public void redirectfragment() {
        Log.d(TAG, "Redirecting to login screen.");
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container_base, antro_hasilPengukuran)
                .addToBackStack(null).commit();
    }

}
