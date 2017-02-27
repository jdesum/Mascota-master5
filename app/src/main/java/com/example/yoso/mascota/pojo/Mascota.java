package com.example.yoso.mascota.pojo;

import java.io.Serializable;

/**
 * POJO Y DATOS DUMMY
 * Created by yoso on 22/01/17.
 */

public class Mascota implements Serializable {
    // Atributos
    private int id;
    private int puntos;
    private String nombre;
    private int idDrawable;

    // Crea un constructor vacio de Mascota
    public Mascota() {

    }

    // Constructor
    public Mascota(int idDrawable, String nombre, int puntos) {
        this.idDrawable = idDrawable;
        this.nombre = nombre;
        this.puntos = puntos;
    }



    // Métodos getters&setters
    public int getIdDrawable() {
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Suma Likes
    public void sumaLike(){
        this.puntos = this.puntos + 1;
    }



}


