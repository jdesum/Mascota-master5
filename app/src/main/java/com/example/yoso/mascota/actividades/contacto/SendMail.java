package com.example.yoso.mascota.actividades.contacto;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by yoso on 4/02/17.
 */
public class SendMail extends AsyncTask<Void, Void, Void>{


    // Declaración Variables
    private Context context;
    private Session session;

    private String email;
    private String password;

   // private String password;
    private String nombre;
    private String correo;
    private String asunto;
    private String mensaje;

    // Mostrar Progressdialog mientras se envia el mail
    private ProgressDialog progressDialog;


    public SendMail(String nombre, String password, String mensaje, String email, String correo, Context context, String asunto) {
        this.nombre = nombre;
        this.password = password;
        this.mensaje = mensaje;
        this.email = email;
        this.correo = correo;
        this.context = context;
        this.asunto = asunto;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Enseña un dialogo mientras se envia el email
        progressDialog = ProgressDialog.show(context, "Enviado mensaje", "Espere porfavor...", false, false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        // Disminuye el dialogo de progreso
        progressDialog.dismiss();

        // Enseña un mensaje de existo
        Toast.makeText(context, "Mensaje enviado", Toast.LENGTH_SHORT).show();


    }



    @Override
    protected Void doInBackground(Void... voids) {
        // Creando propiedades
        Properties props = new Properties();

        // Configuración para gmail
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");

        // props.put("mail.smtp.socketFactory.port", "587");
        // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        // Creando una nueva session
        session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            // Autentifiación del password
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(email, password);
            }
        });

        // Control de excepciones
        // Creación MimeMessage object
        MimeMessage mm = new MimeMessage(session);

        // Setting sender address

        try {
            mm.setFrom(new InternetAddress(email));

            // Seteando dirección de envio
            mm.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(correo)));

            // Añadir asunto
            mm.setSubject(asunto);

            // Añadir mensaje
            mm.setText(mensaje + "\n\n" + nombre);

            // Enviar email
            Transport.send(mm);

        } catch (MessagingException e) {
            e.printStackTrace();
       }

        return null;
    }
}
