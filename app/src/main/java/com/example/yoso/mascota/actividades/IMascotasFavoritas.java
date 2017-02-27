package com.example.yoso.mascota.actividades;

import com.example.yoso.mascota.adaptadores.FavoriteAdapter;
import com.example.yoso.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by yoso on 26/02/17.
 */

public interface IMascotasFavoritas {

    public void generarListVertical();

    public FavoriteAdapter crearAdaptador (ArrayList<Mascota> mascotas);

    public void iniciarFavoriteAdapter (FavoriteAdapter favoriteAdapter);
}

