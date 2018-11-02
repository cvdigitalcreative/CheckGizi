package com.digitalcreative.aplikasigizi.Controller.Adapter;

import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.digitalcreative.aplikasigizi.Model.Model;
import com.digitalcreative.aplikasigizi.R;

import java.util.Collection;
import java.util.List;

public class Riwayat_RecyclerView extends RecyclerView.Adapter<Riwayat_RecyclerView.ViewHolder> {
    private List<Model> list;
    TextView nama, jeniskelamin, umur, beratbadan, panjangbadan, lila, HB, riwayatpenyakit, HBO,
            polio1, polio2, polio3, polio4, campak, anakke, alamat, saudarake, notel, BB_Umur, PB_Umur, IMT_Umur, BB_PB;

    public Riwayat_RecyclerView(List<Model> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Riwayat_RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Riwayat_RecyclerView.ViewHolder holder, int position) {
        final Model model = list.get(position);
        holder.nama.setText(model.getNama());
        holder.tanggal.setText(model.getTanggal());
        holder.bulan.setText(model.getBulan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getContext());
                alertDialog.setCancelable(true);
                LayoutInflater inflater = ((AppCompatActivity)v.getContext()).getLayoutInflater();
                View dialogview = inflater.inflate(R.layout.alertdialog_load_detail_riwayat, null);
                alertDialog.setView(dialogview);
                alertDialog.setTitle("Detail Riwayat");
                //init
                sayHello(dialogview);

                //set
                talktoThem(model);

                AlertDialog dialog = alertDialog.create();
                dialog.show();

            }
        });
    }

    private void talktoThem(Model model) {
        nama.setText(model.getNama());
        jeniskelamin.setText(model.getJenisKelamin());
        umur.setText(model.getUmur());
        beratbadan.setText(model.getBeratBadan());
        panjangbadan.setText(model.getPanjangBadan());
        lila.setText(model.getLila());
        HB.setText(model.getHb());
        HBO.setText(model.getStatus_HBO());
        polio1.setText(model.getStatus_Polio1());
        polio2.setText(model.getStatus_Polio2());
        polio3.setText(model.getStatus_Polio3());
        polio4.setText(model.getStatus_Polio4());
        campak.setText(model.getStatus_campak());
        anakke.setText(model.getAnakke());
        alamat.setText(model.getAlamat());
        saudarake.setText(model.getSaudarake());
        notel.setText(model.getNotel());
        BB_Umur.setText(model.getBB_Umur());
        PB_Umur.setText(model.getPB_Umur());
        IMT_Umur.setText(model.getIMT_Umur());
        BB_PB.setText(model.getPB_BB());
    }

    private void sayHello(View dialogview) {
        //Textview
         nama = dialogview.findViewById(R.id.nama_riwayat);
         jeniskelamin = dialogview.findViewById(R.id.jeniskelamin_riwayat);
         umur = dialogview.findViewById(R.id.umur_riwayat);
         beratbadan = dialogview.findViewById(R.id.bb_riwayat);
         panjangbadan = dialogview.findViewById(R.id.pb_riwayat);
         lila = dialogview.findViewById(R.id.lila_riwayat);
         HB = dialogview.findViewById(R.id.HB_riwayat);
         riwayatpenyakit = dialogview.findViewById(R.id.riwayatpenyakit_riwayat);
         HBO = dialogview.findViewById(R.id.HBO_riwayat);
         polio1 = dialogview.findViewById(R.id.polio1_riwayat);
         polio2 = dialogview.findViewById(R.id.polio2_riwayat);
         polio3 = dialogview.findViewById(R.id.polio3_riwayat);
         polio4 = dialogview.findViewById(R.id.polio4_riwayat);
         campak = dialogview.findViewById(R.id.campak_riwayat);
         anakke = dialogview.findViewById(R.id.anakke_riwayat);
         alamat = dialogview.findViewById(R.id.alamat_riwayat);
         saudarake = dialogview.findViewById(R.id.saudarake_riwayat);
         notel = dialogview.findViewById(R.id.notel_riwayat);
         BB_Umur = dialogview.findViewById(R.id.BB_Umur_riwayat);
         PB_Umur = dialogview.findViewById(R.id.PB_umur_riwayat);
         IMT_Umur = dialogview.findViewById(R.id.imt_umur_riwayat);
         BB_PB = dialogview.findViewById(R.id.BB_PB_riwayat);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, tanggal, bulan;
        public ViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.rwy_nama);
            tanggal = itemView.findViewById(R.id.rwy_tangagl);
            bulan = itemView.findViewById(R.id.rwy_bulan);
        }
    }
}
