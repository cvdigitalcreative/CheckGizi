package com.digitalcreative.gizibalitaku.Boundary.Mainmenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.digitalcreative.gizibalitaku.BaseActivity;
import com.digitalcreative.gizibalitaku.Controller.Antropometri.Decision_Antro;
import com.digitalcreative.gizibalitaku.Controller.Antropometri.Hitung_SDLakilaki;
import com.digitalcreative.gizibalitaku.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Antro_HasilPengukuran extends Fragment {
    CardView cardBB_Umur, cardPB_Umur, cardIMT_Umur, cardPB_BB;
    LinearLayout goto_homepage, informasianak;
    FragmentTransaction ft;
    Antro_InformasiAnak antro_informasiAnak;
    TextView tindakan_1, tindakan_2, tindakan_3, tindakan_4;
    String BB_Umur, PB_Umur, IMT_umur, PB_BB, getnamaAnak, getjenisKelamin, getUmur, getberatBadan, gettinggiBadan,
            getLila, getHb, getpenyakitTerakhir, getHBO, getHBO_polio1, getHBO_polio2,
            getHBO_polio3, getHBO_polio4, getCampak, getanake, getsaudarake, getalamat, getnotel;

    public Antro_HasilPengukuran() {
        //Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_antro_hasil_pengukuran, container, false);

        //init
        descThecomponent(view);

        //getValue
        getTheData();

        //Show The Result
        showtheResult();

        //Action
        informasianak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendThedata();
                ft.replace(R.id.container_base, antro_informasiAnak)
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

    private void sendThedata() {
        Bundle bundle =  new Bundle();
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
        bundle.putString("alamat", getalamat);
        bundle.putString("notel", getnotel);
        bundle.putString("anakke", getanake);
        bundle.putString("saudarake", getsaudarake);
        antro_informasiAnak.setArguments(bundle);
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
        getalamat = getArguments().getString("alamat");
        getanake = getArguments().getString("anakke");
        getsaudarake = getArguments().getString("saudarake");
        getnotel = getArguments().getString("notel");
    }

    private void showtheResult() {
        //Coloring
        paintingCardview();

        //Set Text
        tindakan_1.setText(BB_Umur);
        tindakan_2.setText(PB_Umur);
        tindakan_3.setText(IMT_umur);
        tindakan_4.setText(PB_BB);
    }

    private void paintingCardview() {
        switch (BB_Umur){
            case "Gizi Buruk" :
                cardBB_Umur.setCardBackgroundColor(getResources().getColor(R.color.REDDARK_CV)); break;
            case "Gizi Kurang" :
                cardBB_Umur.setCardBackgroundColor(getResources().getColor(R.color.RED_CV)); break;
            case "Gizi Baik" :
                cardBB_Umur.setCardBackgroundColor(getResources().getColor(R.color.GREEN_CV)); break;
            case "Gizi Lebih" :
                cardBB_Umur.setCardBackgroundColor(getResources().getColor(R.color.REDDARK_CV)); break;
        }
        switch (PB_Umur){
            case "Sangat Pendek" :
                cardPB_Umur.setCardBackgroundColor(getResources().getColor(R.color.REDDARK_CV)); break;
            case "Pendek" :
                cardPB_Umur.setCardBackgroundColor(getResources().getColor(R.color.RED_CV)); break;
            case "Normal" :
                cardPB_Umur.setCardBackgroundColor(getResources().getColor(R.color.GREEN_CV)); break;
            case "Tinggi" :
                cardPB_Umur.setCardBackgroundColor(getResources().getColor(R.color.REDDARK_CV)); break;
        }
        switch (IMT_umur){
            case "Sangat Kurus" :
                cardIMT_Umur.setCardBackgroundColor(getResources().getColor(R.color.REDDARK_CV)); break;
            case "Kurus" :
                cardIMT_Umur.setCardBackgroundColor(getResources().getColor(R.color.RED_CV)); break;
            case "Normal" :
                cardIMT_Umur.setCardBackgroundColor(getResources().getColor(R.color.GREEN_CV)); break;
            case "Gizi Lebih" :
                cardIMT_Umur.setCardBackgroundColor(getResources().getColor(R.color.REDDARK_CV)); break;
        }
        switch (PB_BB){
            case "Sangat Kurus" :
                cardPB_BB.setCardBackgroundColor(getResources().getColor(R.color.REDDARK_CV)); break;
            case "Kurus" :
                cardPB_BB.setCardBackgroundColor(getResources().getColor(R.color.RED_CV)); break;
            case "Normal" :
                cardPB_BB.setCardBackgroundColor(getResources().getColor(R.color.GREEN_CV)); break;
            case "Gemuk" :
                cardPB_BB.setCardBackgroundColor(getResources().getColor(R.color.REDDARK_CV)); break;
        }
    }

    private void descThecomponent(View view) {
        //Invoke Class
        antro_informasiAnak = new Antro_InformasiAnak();

        //LinearLay Clickable Section
        informasianak = view.findViewById(R.id.informasi_anak_btn);
        goto_homepage = view.findViewById(R.id.backtohome_btn);
        ft = getActivity().getSupportFragmentManager().beginTransaction();

        //Cardview
        cardBB_Umur = view.findViewById(R.id.CV_BB_Umur);
        cardPB_Umur = view.findViewById(R.id.CV_PB_Umur);
        cardIMT_Umur = view.findViewById(R.id.CV_IMT_Umur);
        cardPB_BB = view.findViewById(R.id.CV_PB_BB);

        //TextView Section
        tindakan_1 = view.findViewById(R.id.tindakan1);
        tindakan_2 = view.findViewById(R.id.tindakan2);
        tindakan_3 = view.findViewById(R.id.tindakan3);
        tindakan_4 = view.findViewById(R.id.tindakan4);
    }

}
