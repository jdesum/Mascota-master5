package com.example.yoso.mascota.db;

import android.content.Context;

import com.example.yoso.mascota.R;
import com.example.yoso.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by yoso on 18/02/17.
 */

public class ConstructorMiMascota {

    private Context context;

    // Constructor
    public ConstructorMiMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMiMascota(){

        ArrayList<Mascota> miMascota = new ArrayList<>();

        miMascota.add(new Mascota(R.drawable.alfie, "Alfie", 5));
        miMascota.add(new Mascota(R.drawable.alfie, "Alfie", 0));
        miMascota.add(new Mascota(R.drawable.alfie, "Alfie", 3));
        miMascota.add(new Mascota(R.drawable.alfie, "Alfie", 10));
        miMascota.add(new Mascota(R.drawable.alfie, "Alfie", 2));
        miMascota.add(new Mascota(R.drawable.alfie, "Alfie", 3));
        miMascota.add(new Mascota(R.drawable.alfie, "Alfie", 4));
        miMascota.add(new Mascota(R.drawable.alfie, "Alfie", 5));
        miMascota.add(new Mascota(R.drawable.alfie, "Alfie", 8));
        miMascota.add(new Mascota(R.drawable.alfie, "Alfie", 1));
        miMascota.add(new Mascota(R.drawable.alfie, "Alfie", 4));
        miMascota.add(new Mascota(R.drawable.alfie, "Alfie", 5));

        return miMascota;
    }

}
