package com.example.yoso.mascota.adaptadores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Gestiona las tabs, fragmentos e iconos de la pestañas
 * Created by yoso on 22/01/17.
 */

public class PageAdapter extends FragmentPagerAdapter {

    // Arreglo de fragmentos
    ArrayList<Fragment> fragments;


    // Constructor
    public PageAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    // Método posición del fragmento
    @Override
    public Fragment getItem(int position) {

        
                
                
        return fragments.get(position);
    }

    // Método cantidad lista fragmentos
    @Override
    public int getCount() {
        return fragments.size();
    }
}

