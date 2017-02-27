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
import com.example.yoso.mascota.db.ConstructorMascotas;
import com.example.yoso.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by yoso on 24/01/17.
 */

public class PetListAdapter extends RecyclerView.Adapter<PetListAdapter.PetViewHolder>{
    Activity activity;
    ArrayList<Mascota> mascotas;

    // Constructor
    public PetListAdapter(Activity activity, ArrayList<Mascota> mascotas) {
        this.activity = activity;
        this.mascotas = mascotas;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_mascota, parent, false);

        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PetViewHolder petViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);
        petViewHolder.foto.setImageResource(mascota.getIdDrawable());
        petViewHolder.nombre.setText(mascota.getNombre());
        petViewHolder.puntos.setText(String.valueOf(mascota.getPuntos()));

        petViewHolder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        // Clic en like
        petViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                // Mostrar numero de likes
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);

                constructorMascotas.darLikeMascota(mascotas.get(position));
                mascotas.get(position).sumaLike();
                petViewHolder.puntos.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascotas.get(position))));

            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    // Clase Viewholder
    public static class PetViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto;
        private TextView nombre;
        private TextView puntos;
        private ImageButton btnLike;


        public PetViewHolder(View itemView) {
            super(itemView);

            foto = (ImageView) itemView.findViewById(R.id.imagen_mascota);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            puntos = (TextView) itemView.findViewById(R.id.tvPuntuacion);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnWhiteBoneLike);

        }
    }


}
