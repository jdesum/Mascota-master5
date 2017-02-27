package com.example.yoso.mascota.vista_fragmentos;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yoso.mascota.R;
import com.example.yoso.mascota.adaptadores.PetPhotoAdapter;
import com.example.yoso.mascota.pojo.Mascota;
import com.example.yoso.mascota.presentador.RecyclerViewGridMiMascotaPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascota extends Fragment implements IRecyclerViewGridMiMascota {

    // Atributos
    private RecyclerView listaPerfilMascota;
    private ArrayList<Mascota> miMascota;
    private RecyclerViewGridMiMascotaPresenter presentador;
    private Context context;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.perfil_mascota, container, false);

        listaPerfilMascota = (RecyclerView) v.findViewById(R.id.rvMiMascota);


      presentador = new RecyclerViewGridMiMascotaPresenter(getContext(), this);

        return v;
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        listaPerfilMascota.setLayoutManager(glm);

    }

    @Override
    public PetPhotoAdapter crearAdaptadorMiMascota(ArrayList<Mascota> miMascota) {
        PetPhotoAdapter adaptador = new PetPhotoAdapter(getActivity(), miMascota);
        return adaptador;
    }

    @Override
    public void iniciarMiMascotaAdapter(PetPhotoAdapter adaptador) {
        listaPerfilMascota.setAdapter(adaptador);

    }



}
