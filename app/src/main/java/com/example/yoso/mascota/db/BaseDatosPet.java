package com.example.yoso.mascota.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.yoso.mascota.R;
import com.example.yoso.mascota.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by yoso on 18/02/17.
 */

public class BaseDatosPet extends SQLiteOpenHelper {

    // Crear el contexto
    private Context context;


    // Constructor
    public BaseDatosPet(Context context) {
        super(context, ConstantesBaseDatosPet.DATABASE_NAME, null, ConstantesBaseDatosPet.DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatosPet.TABLE_MASCOTA + "(" +
                ConstantesBaseDatosPet.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatosPet.TABLE_MASCOTA_FOTO + " TEXT, " +
                ConstantesBaseDatosPet.TABLE_MASCOTA_NOMBRE + " TEXT " +
                ")";



        String queryCrearTablaMascotaLikes = "CREATE TABLE " + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA + "(" +
                ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatosPet.TABLE_MASCOTA + "(" + ConstantesBaseDatosPet.TABLE_MASCOTA_ID + ")" +
                ")";


        db.execSQL(queryCrearTablaMascota);

        db.execSQL(queryCrearTablaMascotaLikes);

        insertarLasMascotas(db);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        try {
            db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatosPet.TABLE_MASCOTA);
            db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA);
        } catch (SQLiteException e){
            // Manejo de excepciones
        }
        onCreate(db);
    }

    private void insertarLasMascotas(SQLiteDatabase db) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_FOTO, R.drawable.alfie);
        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_NOMBRE, "Alfie");
        db.insert(ConstantesBaseDatosPet.TABLE_MASCOTA, null, contentValues);

        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_FOTO, R.drawable.copito);
        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_NOMBRE, "Copito");
        db.insert(ConstantesBaseDatosPet.TABLE_MASCOTA, null, contentValues);


        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_FOTO, R.drawable.dexter);
        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_NOMBRE, "Dexter");
        db.insert(ConstantesBaseDatosPet.TABLE_MASCOTA, null, contentValues);


        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_FOTO, R.drawable.lucky);
        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_NOMBRE, "Lucky");
        db.insert(ConstantesBaseDatosPet.TABLE_MASCOTA, null, contentValues);


        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_FOTO, R.drawable.lucy);
        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_NOMBRE, "Lucy");
        db.insert(ConstantesBaseDatosPet.TABLE_MASCOTA, null, contentValues);


        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_FOTO, R.drawable.mini);
        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_NOMBRE, "Mini");
        db.insert(ConstantesBaseDatosPet.TABLE_MASCOTA, null, contentValues);


        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_FOTO, R.drawable.niki);
        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_NOMBRE, "Niki");
        db.insert(ConstantesBaseDatosPet.TABLE_MASCOTA, null, contentValues);


        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_FOTO, R.drawable.nina);
        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_NOMBRE, "Nina");
        db.insert(ConstantesBaseDatosPet.TABLE_MASCOTA, null, contentValues);


        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_FOTO, R.drawable.pinky);
        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_NOMBRE, "Pinky");
        db.insert(ConstantesBaseDatosPet.TABLE_MASCOTA, null, contentValues);


        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_FOTO, R.drawable.toby);
        contentValues.put(ConstantesBaseDatosPet.TABLE_MASCOTA_NOMBRE, "Toby");
        db.insert(ConstantesBaseDatosPet.TABLE_MASCOTA, null, contentValues);


    }

    // Método consulta de todas las mascotas
    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatosPet.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        // Recorrer registros
        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setIdDrawable(registros.getInt(1));
            mascotaActual.setNombre(registros.getString(2));

            // Query likes
            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_NUMERO_LIKES +") as likes" +
                    " FROM " + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_ID_MASCOTA + " = " +
                    mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            if (registrosLikes.moveToNext()){
                mascotaActual.setPuntos(registrosLikes.getInt(0));
            } else {
                mascotaActual.setPuntos(0);
            }

            mascotas.add(mascotaActual); // Rellenar la lista contactos
        }

        db.close(); // Cerrar conexión

        return mascotas;
    }

    // Método obtener mascotas favoritas
    public ArrayList<Mascota> obtenerTopMascotas(){
        ArrayList<Mascota> mascotasTop = new ArrayList<>();

        String queryLikes = "SELECT " + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_ID_MASCOTA + ", " +
                "COUNT(" + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_NUMERO_LIKES + ") as likes" +
                " FROM " + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA +
                " GROUP BY " + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_ID_MASCOTA +
                " ORDER BY 2 DESC";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registrosLike = db.rawQuery(queryLikes, null);
        int i = 1;
        while (registrosLike.moveToNext() && i <= 5){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registrosLike.getInt(0));
            mascotaActual.setPuntos(registrosLike.getInt(1));

            String query = "SELECT * FROM " + ConstantesBaseDatosPet.TABLE_MASCOTA +
                    " WHERE " + ConstantesBaseDatosPet.TABLE_MASCOTA_ID + "= " + mascotaActual.getId();

            Cursor registros = db.rawQuery(query, null);

            if (registros.moveToNext()){
                mascotaActual.setIdDrawable(registros.getInt(1));
                mascotaActual.setNombre(registros.getString(2));
            }
            i++;
            mascotasTop.add(mascotaActual);
        }
            db.close();


        return mascotasTop;
    }


    // Método insertar Like Mascota
    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }


    public int obtenerLikesMascota(Mascota mascota) {
        int likes = 0;
        String queryLikes = "SELECT COUNT(" + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_NUMERO_LIKES + ") as likes " +
                " FROM " + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatosPet.TABLE_LIKES_MASCOTA_ID_MASCOTA + " = " +
                mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registrosLikes = db.rawQuery(queryLikes, null);

        if (registrosLikes.moveToNext()){
            likes = registrosLikes.getInt(0);
        }

        db.close();

        return likes;
    }
}
