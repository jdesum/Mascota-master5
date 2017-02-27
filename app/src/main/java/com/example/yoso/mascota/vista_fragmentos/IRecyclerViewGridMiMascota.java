package com.example.yoso.mascota.vista_fragmentos;

import com.example.yoso.mascota.adaptadores.PetPhotoAdapter;
import com.example.yoso.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by yoso on 18/02/17.
 */

public interface IRecyclerViewGridMiMascota {

    public void generarGridLayout();

    public PetPhotoAdapter crearAdaptadorMiMascota(ArrayList<Mascota> miMascota);

    public void iniciarMiMascotaAdapter (PetPhotoAdapter petPhotoAdapter);

}


