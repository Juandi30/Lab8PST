package com.example.lab8pst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicioActivity extends AppCompatActivity {
    Button Inicio,Pagina,IniciarSesion,Revisar,Acerca,BaseDatos,BaseRemota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Inicio = (Button)findViewById(R.id.btnInicio);
        Pagina = (Button)findViewById(R.id.btnUrl);
        IniciarSesion = (Button)findViewById(R.id.idSesion);
        Revisar = (Button)findViewById(R.id.idRevisar);
        Acerca = (Button)findViewById(R.id.idAcerca);
        BaseDatos = (Button)findViewById(R.id.baseDstos);
        BaseRemota = (Button)findViewById(R.id.idBaseRemota);

        Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        Pagina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Pagina.class);
                startActivity(intent);
                finish();
            }
        });
        IniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),iniciarSesion.class);
                startActivity(intent);
                finish();
            }
        });
        Revisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),revisarCorreo.class);
                startActivity(intent);
                finish();
            }
        });
        Acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),acercaDe.class);
                startActivity(intent);
                finish();
            }
        });
        BaseDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),activityDB.class);
                startActivity(intent);
            }
        });
        BaseRemota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BaseRemota.class);
                startActivity(intent);
            }
        });
    }
}