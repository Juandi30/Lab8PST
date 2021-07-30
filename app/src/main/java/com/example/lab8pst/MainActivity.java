package com.example.lab8pst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etnombres, etapellidos, etphone, etmail;
    Intent emailIntent = new Intent(Intent.ACTION_SEND);
    TextView mens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnombres = (EditText)findViewById(R.id.editTextNombres);
        etapellidos = (EditText)findViewById(R.id.editTextApellidos);
        etphone = (EditText)findViewById(R.id.editTextPhone);
        etmail = (EditText)findViewById(R.id.editTextMail);
        mens = (TextView)findViewById(R.id.idMensaje);
   }

    public void enviar (View v){
        String[] to = {"juadiore@espol.edu.ec"};
        String[] cc = {"steanleo@fiec.espol.edu.ec"};
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Formulario de Registro PST");



        emailIntent.putExtra(Intent.EXTRA_TEXT, "Datos de Contacto\n" +
                "Nombres:" + etnombres.getText().toString()+ "\n" +
                "Apellidos:" + etapellidos.getText().toString() +"\n" +
                "Teléfono:" + etphone.getText().toString() + "\n" +
                "Correo Electrónico:" + etmail.getText().toString()+ "\n");

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviando Email"));
            Log.i("termina envio de email", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "No existe cliente Email instalado.", Toast.LENGTH_SHORT).show();
        }
    }
    public void Enviar2 (View view){
        String men = "Datos de Contacto\n" +
                "Nombres:" + etnombres.getText().toString()+ "\n" +
                "Apellidos:" + etapellidos.getText().toString() +"\n" +
                "Teléfono:" + etphone.getText().toString() + "\n" +
                "Correo Electrónico:" + etmail.getText().toString()+ "\n";
        Intent intent =new Intent(getApplicationContext(), mensaje.class);
        intent.putExtra("Mensaje",men);
        startActivity(intent);
    }
}
