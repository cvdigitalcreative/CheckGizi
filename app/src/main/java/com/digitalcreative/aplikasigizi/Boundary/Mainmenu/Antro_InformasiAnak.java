package com.digitalcreative.aplikasigizi.Boundary.Mainmenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.digitalcreative.aplikasigizi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Antro_InformasiAnak extends Fragment {
    TextView IAI_nama, IAI_JK, IAI_umur, IAI_BB, IAI_PB, IAI_lila, IAI_HB, IAI_Riwayat, IAI_getHBO, IAI_getHBO_polio1, IAI_getHBO_polio2,
            IAI_getHBO_polio3, IAI_getHBO_polio4, IAI_getCampak;
    String BB_Umur, PB_Umur, IMT_umur, PB_BB, getnamaAnak, getjenisKelamin, getUmur, getberatBadan, gettinggiBadan,
            getLila, getHb, getpenyakitTerakhir, getHBO, getHBO_polio1, getHBO_polio2,
            getHBO_polio3, getHBO_polio4, getCampak;
    LinearLayout goto_homepage, pemeriksaanak;
    FragmentTransaction ft;
    Antro_HasilPengukuran antro_hasilPengukuran;

    public Antro_InformasiAnak() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_antro_informasi_anak, container, false);

        //Init
        descTheComponent(view);

        //get Value
        getTheData();

        //setComponent
        setTheComponent();

        //Action
        pemeriksaanak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendThedata();
                ft.replace(R.id.container_base, antro_hasilPengukuran)
                        .addToBackStack(null).commit();
            }
        });
        goto_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft.replace(R.id.container_base, new HomeFragment())
                        .addToBackStack(null).commit();
            }
        });

        return view;
    }

    private void getTheData() {
        getHBO = getArguments().getString("HBO");
        getHBO_polio1 = getArguments().getString("Polio1");
        getHBO_polio2 = getArguments().getString("Polio2");
        getHBO_polio3 = getArguments().getString("Polio3");
        getHBO_polio4 = getArguments().getString("Polio4");
        getCampak = getArguments().getString("campak");
        BB_Umur = getArguments().getString("test");
        PB_Umur = getArguments().getString("PBperUmur");
        IMT_umur = getArguments().getString("IMTperUmur");
        PB_BB = getArguments().getString("BBperBB");
        getnamaAnak = getArguments().getString("nama_informasi");
        getjenisKelamin = getArguments().getString("jeniskelamin_informasi");
        getUmur = getArguments().getString("umur");
        getberatBadan = getArguments().getString("beratbadan");
        gettinggiBadan = getArguments().getString("panjangbadan");
        getLila = getArguments().getString("lila");
        getHb = getArguments().getString("HB");
        getpenyakitTerakhir = getArguments().getString("penyakitTerakhir");
    }

    private void sendThedata() {
        Bundle bundle = new Bundle();
        bundle.putString("HBO", getHBO);
        bundle.putString("Polio1", getHBO_polio1);
        bundle.putString("Polio2", getHBO_polio2);
        bundle.putString("Polio3", getHBO_polio3);
        bundle.putString("Polio4", getHBO_polio4);
        bundle.putString("campak", getCampak);
        bundle.putString("test", BB_Umur);
        bundle.putString("PBperUmur", PB_Umur);
        bundle.putString("IMTperUmur", IMT_umur);
        bundle.putString("BBperBB", PB_BB);
        bundle.putString("nama_informasi", getnamaAnak);
        bundle.putString("jeniskelamin_informasi", getjenisKelamin);
        bundle.putString("umur", getUmur);
        bundle.putString("beratbadan", getberatBadan);
        bundle.putString("panjangbadan", gettinggiBadan);
        bundle.putString("lila", getLila);
        bundle.putString("HB", getHb);
        bundle.putString("penyakitTerakhir", getpenyakitTerakhir);
        antro_hasilPengukuran.setArguments(bundle);
    }

    private void setTheComponent() {
        //TextView
        IAI_getHBO.setText(getHBO);
        IAI_getHBO_polio1.setText(getHBO_polio1);
        IAI_getHBO_polio2.setText(getHBO_polio2);
        IAI_getHBO_polio3.setText(getHBO_polio3);
        IAI_getHBO_polio4.setText(getHBO_polio4);
        IAI_getCampak.setText(getCampak);
        IAI_nama.setText(getnamaAnak);
        IAI_JK.setText(getjenisKelamin);
        IAI_umur.setText(getUmur);
        IAI_BB.setText(getberatBadan);
        IAI_PB.setText(gettinggiBadan);
        IAI_lila.setText(getLila);
        IAI_HB.setText(getHb);
        IAI_Riwayat.setText(getpenyakitTerakhir);
    }


    private void descTheComponent(View view) {
        //Invoke Class
        antro_hasilPengukuran = new Antro_HasilPengukuran();

        //LinearLay Clickable Section
        pemeriksaanak = view.findViewById(R.id.pemeriksa_anak_btn_1);
        goto_homepage = view.findViewById(R.id.backtohome_btn_1);
        ft = getActivity().getSupportFragmentManager().beginTransaction();

        //Textview
        IAI_nama = view.findViewById(R.id.nama_informasi);
        IAI_JK = view.findViewById(R.id.jeniskelamin_informasi);
        IAI_umur = view.findViewById(R.id.umur_informasi);
        IAI_BB = view.findViewById(R.id.bb_informasi);
        IAI_PB = view.findViewById(R.id.pb_informasi);
        IAI_lila = view.findViewById(R.id.lila_informasi);
        IAI_HB = view.findViewById(R.id.HB_informasi);
        IAI_Riwayat = view.findViewById(R.id.riwayatpenyakit_informasi);
        IAI_getHBO = view.findViewById(R.id.HBO_informasi);
        IAI_getHBO_polio1 = view.findViewById(R.id.polio1_informasi);
        IAI_getHBO_polio2 = view.findViewById(R.id.polio2_informasi);
        IAI_getHBO_polio3 = view.findViewById(R.id.polio3_informasi);
        IAI_getHBO_polio4 = view.findViewById(R.id.polio4_informasi);
        IAI_getCampak = view.findViewById(R.id.campak_informasi);

    }

}
