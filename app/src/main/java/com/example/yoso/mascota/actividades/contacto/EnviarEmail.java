package com.example.yoso.mascota.actividades.contacto;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.yoso.mascota.R;

public class EnviarEmail extends AppCompatActivity {

    private String email;
    private String password;
    private EditText edtNombre;
    private EditText edtdCorreo;
    private EditText edtdAsunto;
    private EditText edtdMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_email);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Objeto Bundle recibe los parámetros
        final Bundle parametros = getIntent().getExtras();

        email = parametros.getString("correo");
        password = parametros.getString("password");

        edtNombre = (EditText) findViewById(R.id.edtName);
        edtdCorreo = (EditText) findViewById(R.id.edtEmail);
        edtdAsunto = (EditText) findViewById(R.id.edtAsunto);
        edtdMensaje = (EditText) findViewById(R.id.edtMensaje);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabEmail);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Enviar email", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();

                enviar();
            }
        });
    }


    // Método enviar
    public void enviar(){
        String pass = password;
        String mail = email;
        String nombre = edtNombre.getText().toString().trim();
        String correo = edtdCorreo.getText().toString().trim();
        String asunto = edtdAsunto.getText().toString().trim();
        String mensaje = edtdMensaje.getText().toString().trim();

        // Crenado un obj SendMail
        SendMail sendMail = new SendMail(nombre, pass, mensaje, mail, correo, this, asunto);

        // Ejecutando sendmail para enviar el email
        sendMail.execute();
    }



}
