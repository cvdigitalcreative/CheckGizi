package com.digitalcreative.aplikasigizi.Controller.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.digitalcreative.aplikasigizi.Boundary.Mainmenu.Antro_Riwayat;
import com.digitalcreative.aplikasigizi.Model.Model;
import com.digitalcreative.aplikasigizi.R;

import java.util.List;

public class Riwayat_RecyclerView extends RecyclerView.Adapter<Riwayat_RecyclerView.ViewHolder> {
    private List<Model> list;

    public Riwayat_RecyclerView(List<Model> list) {
        this.list =  list;
    }

    @NonNull
    @Override
    public Riwayat_RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Riwayat_RecyclerView.ViewHolder holder, int position) {
        Model model = list.get(position);
        holder.nama.setText(model.getNama());
        holder.BB_Umur.setText(model.getBB_Umur());
        holder.PB_Umur.setText(model.getPB_Umur());
        holder.IMT_Umur.setText(model.getIMT_Umur());
        holder.PB_BB.setText(model.getPB_BB());

        System.out.println("Wee Masuk");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, BB_Umur, PB_Umur, IMT_Umur, PB_BB;
        public ViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.rwy_nama);
            BB_Umur = itemView.findViewById(R.id.rwy_BB_Umur);
            PB_Umur = itemView.findViewById(R.id.rwy_PB_Umur);
            IMT_Umur = itemView.findViewById(R.id.rwy_IMT_Umur);
            PB_BB = itemView.findViewById(R.id.rwy_PB_BB);
        }
    }
}
