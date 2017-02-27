package com.example.yoso.mascota.presentador;

import android.content.Context;

import com.example.yoso.mascota.actividades.IMascotasFavoritas;
import com.example.yoso.mascota.db.ConstructorMascotas;
import com.example.yoso.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by yoso on 26/02/17.
 */

public class RecyclerViewFavoritasPresenter implements IRecyclerViewFavoritasPresenter {

    private IMascotasFavoritas iMascotasFavoritas;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> topMascotas;

    // Constructor
    public RecyclerViewFavoritasPresenter(IMascotasFavoritas iMascotasFavoritas, Context context ) {
        this.iMascotasFavoritas = iMascotasFavoritas;
        this.context = context;
        obtenerTopMascotasBD();
    }

    @Override
    public void obtenerTopMascotasBD() {
        constructorMascotas  = new ConstructorMascotas(context);
        topMascotas = constructorMascotas.obtenerTopMascotas();
        mostrarTopMascotasRV();

    }

    @Override
    public void mostrarTopMascotasRV() {
        iMascotasFavoritas.iniciarFavoriteAdapter(iMascotasFavoritas.crearAdaptador(topMascotas));
        iMascotasFavoritas.generarListVertical();

    }
}
