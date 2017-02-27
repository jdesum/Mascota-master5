package com.example.yoso.mascota.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.yoso.mascota.R;
import com.example.yoso.mascota.actividades.contacto.Contacto;
import com.example.yoso.mascota.adaptadores.PageAdapter;
import com.example.yoso.mascota.vista_fragmentos.ListaMascotas;
import com.example.yoso.mascota.vista_fragmentos.PerfilMascota;

import java.util.ArrayList;

public class ActividadPrincipal extends AppCompatActivity {

    // Atributos
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        // View
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);


        // Validación
        if (toolbar !=null){
            setSupportActionBar(toolbar);
        }



        // Llamada al método
        setUpViewPager();



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Fotografiar mascota", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }




    // Método recibir el arreglo de fragments
    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();


        fragments.add(new ListaMascotas());
        fragments.add(new PerfilMascota());

        return fragments;
    }


    // Método  activar los fragmentos y recibir el arreglo de fragmentos
    private void setUpViewPager() {

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));

         tabLayout.setupWithViewPager(viewPager);

        // Añadir titulos y los iconos a las tabs
        tabLayout.getTabAt(0).setText("Mascotas");
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home);
        tabLayout.getTabAt(1).setText("Mi Mascota");
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_dog);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.favoritos) {
            // Intent a la lista de 5 mascotas favoritas
            Toast.makeText(this, "Mostrar 5 mascotas favoritas", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, MascotasFavoritas.class);
            startActivity(i);

            return true;
        }

        if (id == R.id.mContacto){
            // Intent a contacto
            Toast.makeText(this, "Contacto", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, Contacto.class);
            startActivity(i);

            return true;
        }

        if (id == R.id.mAcercaDe){
            Toast.makeText(this, "Acerca de", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, AcercaDe.class);
            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
