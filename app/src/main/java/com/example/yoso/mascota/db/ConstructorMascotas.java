package com.example.yoso.mascota.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.yoso.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Interactor
 * Created by yoso on 18/02/17.
 */

public class ConstructorMascotas {

    private static final Integer LIKE = 1;
    private Context context;

    // Constructor
    public ConstructorMascotas(Context context) {
        this.context = context;
    }


    public ArrayList<Mascota> obtenerDatos() {
        BaseDatosPet db = new BaseDatosPet(context);

        return db.obtenerTodasLasMascotas();

    }

    public void darLikeMascota(Mascota mascota) {
        BaseDatosPet db = new BaseDatosPet(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);

        db.insertarLikeMascota(contentValues);

    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatosPet db = new BaseDatosPet(context);
        return db.obtenerLikesMascota(mascota);
    }

    public ArrayList<Mascota> obtenerTopMascotas(){
        BaseDatosPet db = new BaseDatosPet(context);
        return db.obtenerTopMascotas();
    }





}

