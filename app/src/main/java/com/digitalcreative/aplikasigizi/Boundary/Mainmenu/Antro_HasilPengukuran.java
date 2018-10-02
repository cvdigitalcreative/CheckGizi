package com.digitalcreative.aplikasigizi.Boundary.Mainmenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.digitalcreative.aplikasigizi.Controller.Antropometri.Decision_Antro;
import com.digitalcreative.aplikasigizi.Controller.Antropometri.Hitung_SDLakilaki;
import com.digitalcreative.aplikasigizi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Antro_HasilPengukuran extends Fragment {
    Button goto_homepage;
    FragmentTransaction ft;
    TextView tindakan_1, tindakan_2, tindakan_3, tindakan_4;
    String BB_Umur, PB_Umur, IMT_umur, PB_BB;

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
//        System.out.println(getActivity().getIntent().getExtras().getString("test"));
//        //get Data
        BB_Umur = getArguments().getString("test");
        PB_Umur = getArguments().getString("PBperUmur");
        IMT_umur = getArguments().getString("IMTperUmur");
        PB_BB = getArguments().getString("BBperBB");

        //Show The Result
        showtheResult();

        //Action
        goto_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft.replace(R.id.container_base, new Homepage())
                        .addToBackStack(null).commit();
            }
        });
        return view;
    }

    private void showtheResult() {
        tindakan_1.setText(BB_Umur);
        tindakan_2.setText(PB_Umur);
        tindakan_3.setText(IMT_umur);
        tindakan_4.setText(PB_BB);
    }

    private void descThecomponent(View view) {
        //Button Section
        goto_homepage = view.findViewById(R.id.back_to_main_menu);
        ft = getActivity().getSupportFragmentManager().beginTransaction();

        //TextView Section
        tindakan_1 = view.findViewById(R.id.tindakan1);
        tindakan_2 = view.findViewById(R.id.tindakan2);
        tindakan_3 = view.findViewById(R.id.tindakan3);
        tindakan_4 = view.findViewById(R.id.tindakan4);
    }

}
