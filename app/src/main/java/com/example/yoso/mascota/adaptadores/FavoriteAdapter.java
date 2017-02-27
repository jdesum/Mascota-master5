package com.example.yoso.mascota.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yoso.mascota.R;
import com.example.yoso.mascota.pojo.Mascota;

import java.util.ArrayList;



/**
 * Created by yoso on 28/01/17.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>{

    private Activity activity;
   private ArrayList<Mascota> mascotas;

    // Constructor
    public FavoriteAdapter(Activity activity, ArrayList<Mascota> mascotas) {
        this.activity = activity;
        this.mascotas = mascotas;
    }




    @Override
    public FavoriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_mascota, parent, false);

        return new FavoriteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FavoriteViewHolder favoriteViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        favoriteViewHolder.foto.setImageResource(mascota.getIdDrawable());
        favoriteViewHolder.name.setText(mascota.getNombre());
        favoriteViewHolder.likes.setText(String.valueOf(mascota.getPuntos()));



        // Clicar la foto
        favoriteViewHolder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });


        /*
        // Clicar el hueso blanco
        favoriteViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        })
        */

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    // Clase Viewholder
    public static class FavoriteViewHolder extends RecyclerView.ViewHolder {
        // Atributos
        private ImageView foto;
        private TextView name;
        private TextView likes;
        private ImageButton btnLike;

        public FavoriteViewHolder(View itemView) {
            super(itemView);

            foto = (ImageView) itemView.findViewById(R.id.imagen_mascota);
            name = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            likes = (TextView) itemView.findViewById(R.id.tvPuntuacion);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnWhiteBoneLike);
        }
    }
}
