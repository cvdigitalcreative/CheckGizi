package com.digitalcreative.gizibalitaku.Boundary.Mainmenu;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.digitalcreative.gizibalitaku.Controller.Adapter.Riwayat_RecyclerView;
import com.digitalcreative.gizibalitaku.Controller.Firebase.FirebaseController;
import com.digitalcreative.gizibalitaku.Model.Model;
import com.digitalcreative.gizibalitaku.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class Antro_Riwayat extends Fragment {
    Riwayat_RecyclerView riwayat_recyclerView;
    FirebaseController firebaseController;
    Antro_Pengukuran antro_pengukuran;
    List<Model> list = new ArrayList<>();
    RecyclerView recyclerView;
    Context context;
    LinearLayout linearLayout;
    TextView judul, subjudul;
    Toolbar toolbar;

    public Antro_Riwayat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_riwayat_antro, container, false);

        //Init
        sayHelloboys(view);

        //Set Value
        talkTothem();

        //Get Value
        getFromThem();

        //Actions
        doitBoys();

        return view;
    }

    private void getFromThem() {
        //Invoke Class
        firebaseController = new FirebaseController();
        antro_pengukuran = new Antro_Pengukuran();
    }

    private void doitBoys() {
        //Recycler
        riwayat_recyclerView = new Riwayat_RecyclerView(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        //Invoke Class Firebase
        list = firebaseController.loadData(list, recyclerView, riwayat_recyclerView);

        //callme BUtton
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container_base, antro_pengukuran)
                        .addToBackStack(HomeFragment.class.getSimpleName())
                        .commit();
            }
        });
    }

    private void talkTothem() {
        //Linear Layout
        linearLayout.setRotation(180);

        //Toolbar
        setHasOptionsMenu(true);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        //TextView
        judul.setText("Aplikasi Antropometri");
        subjudul.setText("Riwayat Gizi");

    }

    private void sayHelloboys(View view) {
        //Linear Layout
        linearLayout = view.findViewById(R.id.rotation_button);

        //Recycler View
        recyclerView = view.findViewById(R.id.recyle_riwayat);

        //Textview
        subjudul = view.findViewById(R.id.sub_title);
        judul = view.findViewById(R.id.text_title);

        //Toolbar
        toolbar = view.findViewById(R.id.toolbars);
    }

}
