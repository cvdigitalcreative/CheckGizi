package com.digitalcreative.gizibalitaku.Boundary.Mainmenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.digitalcreative.gizibalitaku.R;
import com.digitalcreative.gizibalitaku.Boundary.LoginandRegister.LoginForm;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    Button do_ukur_antro, riwayat_antro, logout;
    FragmentTransaction ft;
    FirebaseUser user;
    FirebaseAuth firebaseAuth;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Init
        descTheComponent(view);

        //Set

        //Actions
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                ft.replace(R.id.container_base, new LoginForm())
                        .commit();
            }
        });

        do_ukur_antro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft.replace(R.id.container_base, new Antro_Pengukuran())
                        .addToBackStack(null)
                        .commit();
            }
        });

        riwayat_antro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ft.replace(R.id.container_base, new Antro_Riwayat())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }

    private void descTheComponent(View view) {
        //Button
        do_ukur_antro = view.findViewById(R.id.btn_home_pengukuran_antropometri);
        riwayat_antro = view.findViewById(R.id.btn_home_riwayat_antropometri);
        logout = view.findViewById(R.id.logout);

        //Fragment Transition
        ft = getActivity().getSupportFragmentManager().beginTransaction();

        //TextView

        //Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
    }
}
