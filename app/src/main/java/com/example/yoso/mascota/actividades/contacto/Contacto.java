package com.example.yoso.mascota.actividades.contacto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yoso.mascota.R;

public class Contacto extends AppCompatActivity {

    EditText email;
    EditText pass;
    EditText pass2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);



        email = (EditText) findViewById(R.id.etEmail);
        pass = (EditText) findViewById(R.id.etPass);
        pass2 = (EditText) findViewById(R.id.etPass2);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    // Este método se ejecutara cuando se preison el botón

     public void verificarPass(View view){



            String correo = email.getText().toString();
            String password = pass.getText().toString();
            String passRepeat = pass2.getText().toString();



         if ( password.equals(passRepeat) && password.length() != 0  && correo.length() != 0){

             // Toast.makeText(this, "Password correcto", Toast.LENGTH_SHORT).show();




                Intent i = new Intent(this, EnviarEmail.class);

                i.putExtra(getResources().getString(R.string.mi_email), correo);
                i.putExtra(getResources().getString(R.string.mi_pass), password);


                startActivity(i);

                finish();


             }else Toast.makeText(this, "No has introducido Email o Password no correcto", Toast.LENGTH_SHORT).show();


         }




}
