package com.example.yoso.mascota.actividades;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.yoso.mascota.R;
import com.example.yoso.mascota.actividades.contacto.Contacto;
import com.example.yoso.mascota.adaptadores.FavoriteAdapter;
import com.example.yoso.mascota.pojo.Mascota;
import com.example.yoso.mascota.presentador.IRecyclerViewFavoritasPresenter;
import com.example.yoso.mascota.presentador.RecyclerViewFavoritasPresenter;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IMascotasFavoritas  {

    private RecyclerView listFavoritas;
    private Context context;
    private IRecyclerViewFavoritasPresenter presenter;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mascotas_favoritas);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Validación
        if (toolbar !=null){
            setSupportActionBar(toolbar);
        }




        listFavoritas = (RecyclerView) findViewById(R.id.rvFavorites);

        listFavoritas.setHasFixedSize(true);

      presenter = new RecyclerViewFavoritasPresenter(this, getApplicationContext());




    }


    @Override
    public void generarListVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listFavoritas.setLayoutManager(llm);

    }

    @Override
    public FavoriteAdapter crearAdaptador(ArrayList<Mascota> mascotas) {

        FavoriteAdapter adaptador= new FavoriteAdapter(this, mascotas);
        if (adaptador.getItemCount() == 0){
            Toast.makeText(MascotasFavoritas.this, "Ninguna mascota tiene likes", Toast.LENGTH_SHORT).show();
        }

        return adaptador;
    }

    @Override
    public void iniciarFavoriteAdapter(FavoriteAdapter favoriteAdapter) {
        listFavoritas.setAdapter(favoriteAdapter);

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
