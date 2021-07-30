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

public class revisarCorreo extends AppCompatActivity {

    WebView correo;
    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisar_correo);


        regresar = (Button) findViewById(R.id.IdRegresar);
        correo = (WebView) findViewById(R.id.webView);


        correo.getSettings().setJavaScriptEnabled(true);
        correo.setWebViewClient(new WebViewClient());

        correo.loadUrl("https://gmail.com");


        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InicioActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}