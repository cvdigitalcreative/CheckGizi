package com.digitalcreative.aplikasigizi.Boundary.Mainmenu;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.digitalcreative.aplikasigizi.Controller.Adapter.Riwayat_RecyclerView;
import com.digitalcreative.aplikasigizi.Controller.Firebase.FirebaseController;
import com.digitalcreative.aplikasigizi.Model.Model;
import com.digitalcreative.aplikasigizi.R;
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
    List<Model> list = new ArrayList<>();
    RecyclerView recyclerView;
    Context context;

    public Antro_Riwayat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_riwayat_antro, container, false);
        //Init
        recyclerView = view.findViewById(R.id.recyle_riwayat);

        //Recycler
        riwayat_recyclerView = new Riwayat_RecyclerView(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        //Invoke Class Firebase
        firebaseController = new FirebaseController();
        list = firebaseController.loadData(list, recyclerView, riwayat_recyclerView);

        return view;
    }
}
