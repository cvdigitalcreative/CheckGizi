package com.digitalcreative.gizibalitaku.Boundary.Mainmenu;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.digitalcreative.gizibalitaku.Controller.View.View_Control;
import com.digitalcreative.gizibalitaku.R;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class Antro_Pengukuran extends Fragment {
    View_Control view_control;
    Antro_HasilPengukuran antro_hasilPengukuran;
    EditText namaAnak, beratBadan, tinggiBadan, penyakitTerakhir, umur, lila, hb, alamat, noHP, anake, saudarake;
    String getnamaAnak, getjenisKelamin, getberatBadan, gettinggiBadan, getalamat, getnoHp, getanake, getsaudarake,
            getpenyakitTerakhir, getUmur, getLila, getHb, getHBO, getHBO_polio1, getHBO_polio2,
            getHBO_polio3, getHBO_polio4, getCampak;
    Button hitungAntro, hbo, polio1, campak, polio2, polio3, polio4, jk_lelaki, jk_Perempuan;
    int mCounter_hbo, mCounter_polio1, mCounter_polio2, mCounter_polio3, mCounter_polio4, mCounter_campak;
    TextView judul, subjudul;
    Toolbar toolbar;
    LinearLayout linearLayout;

    public Antro_Pengukuran() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pengukuran_antro, container, false);

        //init
        descTheComponent(view);

        //Set
        setTheValue();

        //Actions
        actionsStatImunisasi();
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Antro_Riwayat antro_riwayat =  new Antro_Riwayat();
                redirectfragment(antro_riwayat);

            }
        });

        hitungAntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get The Value
                getTheValue();

                //Sout
                System.out.println("Umur : " +getUmur);
                System.out.println("Berat Badan : " +getberatBadan);
                System.out.println("Tinggi : " +gettinggiBadan);

                //Check Value When It's more than The limits
                if (Integer.valueOf(getUmur) <= 24){
                    if(Double.valueOf(gettinggiBadan) >= 45 && Double.valueOf(gettinggiBadan) <= 110){
                        doitData();
                    } else {
                        Toast.makeText(getActivity(), "Tinggi Badan Melebihi Limit (Range 45cm - 110cm)", Toast.LENGTH_LONG).show();
                    }
                } else if(Integer.valueOf(getUmur) > 24 && Integer.valueOf(getUmur) <= 60){
                    if(Double.valueOf(gettinggiBadan) >= 65 && Double.valueOf(gettinggiBadan) <= 120){
                        doitData();
                    } else {
                        Toast.makeText(getActivity(), "Tinggi Badan Melebihi Limit (Range 65cm - 120cm)", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Umur Melebihi Limit (Range 0 bulan - 60 bulan)", Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }

    private void setTheValue() {
        //Toolbar
        setHasOptionsMenu(true);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        //TextView
        judul.setText("Aplikasi Antropometri");
        subjudul.setText("Periksa Gizi");
    }

    private void doitData() {
        antro_hasilPengukuran =  new Antro_HasilPengukuran();

        view_control =  new View_Control(getUmur, getalamat, getnoHp, getanake, getsaudarake, getberatBadan,
                gettinggiBadan, getjenisKelamin, getnamaAnak, getpenyakitTerakhir, getLila, getHb, getHBO,
                getHBO_polio1, getHBO_polio2, getHBO_polio3, getHBO_polio4, getCampak);
        view_control.getData(antro_hasilPengukuran);
        view_control.saveToFirebase();

        //show The result
        redirectfragment(antro_hasilPengukuran);
    }

    private void getTheValue() {
        //get String Section
        getnamaAnak = namaAnak.getText().toString();
        getberatBadan = beratBadan.getText().toString();
        gettinggiBadan = tinggiBadan.getText().toString();
        getpenyakitTerakhir = penyakitTerakhir.getText().toString();
        getUmur = umur.getText().toString();
        getLila = lila.getText().toString();
        getHb = hb.getText().toString();
        getalamat = alamat.getText().toString();
        getnoHp = noHP.getText().toString();
        getanake = anake.getText().toString();
        getsaudarake = saudarake.getText().toString();
    }

    private void descTheComponent(View view) {
        //Linear Layout
        linearLayout = view.findViewById(R.id.rotation_button);

        //Textview
        subjudul = view.findViewById(R.id.sub_title);
        judul = view.findViewById(R.id.text_title);

        //Toolbar
        toolbar = view.findViewById(R.id.toolbars);

        //EditText Section
        namaAnak = view.findViewById(R.id.ap_input_nama_anak);
        anake = view.findViewById(R.id.ap_anakke);
        noHP = view.findViewById(R.id.no_hp_nama_anak);
        alamat = view.findViewById(R.id.ap_alamat_nama_anak);
        saudarake = view.findViewById(R.id.ap_berapasaudara);
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
        getHBO = "Tidak";
        getHBO_polio1 = "Tidak";
        getHBO_polio2 = "Tidak";
        getHBO_polio3 = "Tidak";
        getHBO_polio4 = "Tidak";
        getCampak = "Tidak";

        jk_lelaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jk_lelaki.setTypeface(Typeface.DEFAULT_BOLD);
                jk_Perempuan.setTypeface(Typeface.DEFAULT);

                jk_lelaki.setSelected(true);
                jk_Perempuan.setSelected(false);

                getjenisKelamin = "Laki-laki";
            }
        });

        jk_Perempuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jk_lelaki.setTypeface(Typeface.DEFAULT);
                jk_Perempuan.setTypeface(Typeface.DEFAULT_BOLD);

                jk_lelaki.setSelected(false);
                jk_Perempuan.setSelected(true);

                getjenisKelamin = "Perempuan";
            }
        });


        hbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter_hbo += 1;
                if (mCounter_hbo % 2 == 0){
                    hbo.setTypeface(Typeface.DEFAULT);
                    hbo.setSelected(false);
                    getHBO = "Tidak";
                } else {
                    hbo.setTypeface(Typeface.DEFAULT_BOLD);
                    hbo.setSelected(true);
                    getHBO = "Ya";
                }
            }
        });

        polio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter_polio1 += 1;
                if (mCounter_polio1 % 2 == 0){
                    polio1.setTypeface(Typeface.DEFAULT);
                    polio1.setSelected(false);
                    getHBO_polio1 = "Tidak";
                } else {
                    polio1.setTypeface(Typeface.DEFAULT_BOLD);
                    polio1.setSelected(true);
                    getHBO_polio1 = "Ya";
                }
            }
        });

        polio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter_polio2 += 1;
                if (mCounter_polio2 % 2 == 0){
                    polio2.setTypeface(Typeface.DEFAULT);
                    polio2.setSelected(false);
                    getHBO_polio2 = "Tidak";
                } else {
                    polio2.setTypeface(Typeface.DEFAULT_BOLD);
                    polio2.setSelected(true);
                    getHBO_polio2 = "Ya";
                }
            }
        });

        polio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter_polio3 += 1;

                if(mCounter_polio3 % 2 == 0){
                    polio3.setTypeface(Typeface.DEFAULT);
                    polio3.setSelected(false);
                    getHBO_polio3 = "Tidak";
                } else {
                    polio3.setTypeface(Typeface.DEFAULT_BOLD);
                    polio3.setSelected(true);
                    getHBO_polio3 = "Ya";
                }
            }
        });

        polio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter_polio4 += 1;

                if(mCounter_polio4 % 2 == 0){
                    polio4.setTypeface(Typeface.DEFAULT);
                    polio4.setSelected(false);
                    getHBO_polio4 = "Tidak";
                } else {
                    polio4.setTypeface(Typeface.DEFAULT_BOLD);
                    polio4.setSelected(true);
                    getHBO_polio4 = "Ya";
                }
            }
        });

        campak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter_campak += 1;

                if(mCounter_campak % 2 == 0){
                    campak.setTypeface(Typeface.DEFAULT);
                    campak.setSelected(false);
                    getCampak = "Tidak";
                } else {
                    campak.setTypeface(Typeface.DEFAULT_BOLD);
                    campak.setSelected(true);
                    getCampak = "Ya";
                }
            }
        });
    }


    private void redirectfragment(Fragment fragment) {
        Log.d(TAG, "Redirecting screen.");
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container_base, fragment)
                .commit();
    }
}
