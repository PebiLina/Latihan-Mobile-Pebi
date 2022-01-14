package com.example.crud_mobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MapelAdapter extends RecyclerView.Adapter<MapelAdapter.ViewHolderSaya> {

    private Context context;
    private ArrayList mapel_id, mapel_nama, mapel_gurumapel, mapel_ruang;

    MapelAdapter(
            Context context,
            ArrayList mapel_id,
            ArrayList mapel_nama,
            ArrayList mapel_gurumapel,
            ArrayList mapel_ruang
    ){
        this.context    = context;
        this.mapel_id    = mapel_id;
        this.mapel_nama = mapel_nama;
        this.mapel_gurumapel = mapel_gurumapel;
        this.mapel_ruang   = mapel_ruang;

    }

    @NonNull
    @Override
    public ViewHolderSaya onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflaterKita = LayoutInflater.from(context);
        View viewSaya = inflaterKita.inflate(R.layout.pebilinaparsauliansinaga8020180036, parent, false);
        return new ViewHolderSaya(viewSaya);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSaya holder, @SuppressLint("RecyclerView") int position) {
        holder.txt_id_mapel.setText(String.valueOf(mapel_id.get(position)));
        holder.txt_nama_mapel.setText(String.valueOf(mapel_nama.get(position)));
        holder.txt_mapel_gurumapel.setText(String.valueOf(mapel_gurumapel.get(position)));
        holder.txt_mapel_ruang.setText(String.valueOf(mapel_ruang.get(position)));
        holder.layoutUtama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKita = new Intent(context, UbahMapelActivity.class);
                intentKita.putExtra("id", String.valueOf(mapel_id.get(position)));
                intentKita.putExtra("nama", String.valueOf(mapel_nama.get(position)));
                intentKita.putExtra("gurumapel", String.valueOf(mapel_gurumapel.get(position)));
                intentKita.putExtra("ruang", String.valueOf(mapel_ruang.get(position)));

                context.startActivity(intentKita);
            }
        });
    }

    public int getItemCount() {
        return mapel_id.size();
    }

    public class ViewHolderSaya extends RecyclerView.ViewHolder {

        TextView txt_id_mapel, txt_nama_mapel, txt_mapel_gurumapel, txt_mapel_ruang;
        LinearLayout layoutUtama;

        public ViewHolderSaya(@NonNull View itemView) {
            super(itemView);

            txt_id_mapel         = itemView.findViewById(R.id.txt_mapel_id);
            txt_nama_mapel      = itemView.findViewById(R.id.txt_mapel_nama);
            txt_mapel_gurumapel  = itemView.findViewById(R.id.txt_mapel_guru);
            txt_mapel_ruang        = itemView.findViewById(R.id.txt_mapel_ruang);
            layoutUtama         = itemView.findViewById(R.id.layout_utama);
        }
    }
}
