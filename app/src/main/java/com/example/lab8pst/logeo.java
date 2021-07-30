package com.example.lab8pst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class logeo extends AppCompatActivity {
    TextView datos;
    Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logeo);

        datos = (TextView)findViewById(R.id.datos);
        regresar =(Button)findViewById(R.id.idRe);

        Bundle extra = getIntent().getExtras();
        String mens = extra.getString("Datos");
        datos.setText(mens);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),iniciarSesion.class);
                startActivity(intent);
                finish();
            }
        });

    }
}