package com.example.yoso.mascota.presentador;

import android.content.Context;

import com.example.yoso.mascota.db.ConstructorMascotas;
import com.example.yoso.mascota.pojo.Mascota;
import com.example.yoso.mascota.vista_fragmentos.IRecyclerViewListaMascota;

import java.util.ArrayList;

/**
 * Created by yoso on 18/02/17.
 */

public class RecyclerViewListaMascotaPresenter implements IRecyclerViewListaMascotaPresenter {

    private IRecyclerViewListaMascota iRecyclerViewListaMascota;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    // Constructor
    public RecyclerViewListaMascotaPresenter(IRecyclerViewListaMascota iRecyclerViewListaMascota, Context context) {
        this.iRecyclerViewListaMascota = iRecyclerViewListaMascota;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewListaMascota.inicializadorAdaptadorRV(iRecyclerViewListaMascota.crearAdaptador(mascotas));
        iRecyclerViewListaMascota.generarLinearLayoutVertical();
    }
}
