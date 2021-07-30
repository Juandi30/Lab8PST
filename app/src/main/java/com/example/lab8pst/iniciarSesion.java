package com.example.lab8pst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class iniciarSesion extends AppCompatActivity {
    EditText usuario,contrasena;
    Button iniciar,regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        iniciar=(Button)findViewById(R.id.idIni);
        regresar=(Button)findViewById(R.id.idRegIni);
        usuario=(EditText)findViewById(R.id.idUsuario);
        contrasena=(EditText)findViewById(R.id.idCon);


        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usua = usuario.getText().toString().trim();
                String con = contrasena.getText().toString().trim();
                Intent intent = new Intent(getApplicationContext(),logeo.class);
                intent.putExtra("Datos",usua);
                startActivity(intent);
                finish();

            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),InicioActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}