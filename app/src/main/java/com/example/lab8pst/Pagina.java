package com.example.lab8pst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Pagina extends AppCompatActivity {
    WebView pagina;
    EditText Url;
    Button buscar,regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina);

        pagina = (WebView)findViewById(R.id.idPagina);
        Url = (EditText)findViewById(R.id.idUrl);
        buscar=(Button)findViewById(R.id.idCargar);
        regresar=(Button)findViewById(R.id.idRegresar);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = Url.getText().toString().trim();
                pagina.getSettings().setJavaScriptEnabled(true);
                pagina.setWebViewClient(new WebViewClient());

                pagina.loadUrl("https://"+url);
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),InicioActivity.class);
                startActivity(intent);
            }
        });

    }
}