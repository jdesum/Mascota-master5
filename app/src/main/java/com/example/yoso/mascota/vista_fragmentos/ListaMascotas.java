package com.example.yoso.mascota.vista_fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yoso.mascota.R;
import com.example.yoso.mascota.adaptadores.PetListAdapter;
import com.example.yoso.mascota.pojo.Mascota;
import com.example.yoso.mascota.presentador.IRecyclerViewListaMascotaPresenter;
import com.example.yoso.mascota.presentador.RecyclerViewListaMascotaPresenter;

import java.util.ArrayList;

/**
 * Fragmento
 * A simple {@link Fragment} subclass.
 */
public class ListaMascotas extends Fragment implements IRecyclerViewListaMascota {

    // Atributos
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewListaMascotaPresenter presenter;

    public ListaMascotas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lista_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        // Llamar el presentador
        presenter = new RecyclerViewListaMascotaPresenter(this, getContext());

        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public PetListAdapter crearAdaptador(ArrayList<Mascota> mascotas) {

        PetListAdapter adaptador = new PetListAdapter(getActivity(), mascotas);
        return adaptador;
    }

    @Override
    public void inicializadorAdaptadorRV(PetListAdapter adaptador) {

        listaMascotas.setAdapter(adaptador);

    }
}
