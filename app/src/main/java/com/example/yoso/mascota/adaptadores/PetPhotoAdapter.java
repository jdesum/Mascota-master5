package com.example.yoso.mascota.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yoso.mascota.R;
import com.example.yoso.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by yoso on 25/01/17.
 */

public class PetPhotoAdapter extends RecyclerView.Adapter<PetPhotoAdapter.PetPhotoViewHolder>{

    Activity activity;
    private ArrayList<Mascota> miMascota;


    public PetPhotoAdapter(Activity activity, ArrayList<Mascota> miMascota) {
        this.activity = activity;
        this.miMascota = miMascota;
    }

    // Método dar vida al cardview para pasarlo al viewholder para que él obtenga los view
    @Override
    public PetPhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foto_mascota, parent, false);

        return new PetPhotoViewHolder(v);
    }

    // Método que asocia cada elemento de la lista a cada view
    @Override
    public void onBindViewHolder(PetPhotoViewHolder petPhotoViewHolder, int position) {

        Mascota mascota = miMascota.get(position);

        petPhotoViewHolder.imgMiMascotaFoto.setImageResource(mascota.getIdDrawable());
        petPhotoViewHolder.tvMiMascotaPuntos.setText(String.valueOf(mascota.getPuntos()));



    }

    // Método cantidad de items que contiene la lista
    @Override
    public int getItemCount() {
        return miMascota.size();
    }


    // Static Clase ViewHolder
    public static class PetPhotoViewHolder extends RecyclerView.ViewHolder {
       // Declarar los Views
        private ImageView imgMiMascotaFoto;
        private TextView tvMiMascotaPuntos;

        public PetPhotoViewHolder(View itemView) {
            super(itemView);

            imgMiMascotaFoto = (ImageView) itemView.findViewById(R.id.imgMiMascotaCV);
            tvMiMascotaPuntos = (TextView) itemView.findViewById(R.id.tvPuntosMiMascotaCV);


        }
    }

}
