package com.example.yoso.mascota.presentador;

import android.content.Context;

import com.example.yoso.mascota.db.ConstructorMiMascota;
import com.example.yoso.mascota.pojo.Mascota;
import com.example.yoso.mascota.vista_fragmentos.IRecyclerViewGridMiMascota;

import java.util.ArrayList;

/**
 * Created by yoso on 18/02/17.
 */

public class RecyclerViewGridMiMascotaPresenter implements IRecyclerViewGridMiMascotaPresenter {

    private IRecyclerViewGridMiMascota iRecyclerViewGridMiMascota;
    private Context context;
    private ConstructorMiMascota constructorMiMascota;
    private ArrayList<Mascota> miMascota;

    public RecyclerViewGridMiMascotaPresenter(Context context, IRecyclerViewGridMiMascota iRecyclerViewGridMiMascota) {
        this.context = context;
        this.iRecyclerViewGridMiMascota = iRecyclerViewGridMiMascota;
        obtenerMiMascotaBaseDatos();
    }


    @Override
    public void obtenerMiMascotaBaseDatos() {
        constructorMiMascota = new ConstructorMiMascota(context);
        miMascota = constructorMiMascota.obtenerMiMascota();
        mostrarMiMascotasRV();

    }

    @Override
    public void mostrarMiMascotasRV() {
        iRecyclerViewGridMiMascota.iniciarMiMascotaAdapter(iRecyclerViewGridMiMascota.crearAdaptadorMiMascota(miMascota));
        iRecyclerViewGridMiMascota.generarGridLayout();


    }
}