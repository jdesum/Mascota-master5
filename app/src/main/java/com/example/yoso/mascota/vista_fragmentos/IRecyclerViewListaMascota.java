package com.example.yoso.mascota.vista_fragmentos;

import com.example.yoso.mascota.adaptadores.PetListAdapter;
import com.example.yoso.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by yoso on 18/02/17.
 */

public interface IRecyclerViewListaMascota {

    public void generarLinearLayoutVertical();

    public PetListAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializadorAdaptadorRV(PetListAdapter adaptador);
}
