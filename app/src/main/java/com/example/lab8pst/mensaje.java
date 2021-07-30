package com.example.lab8pst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class mensaje extends AppCompatActivity {
    TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        mensaje = (TextView) findViewById(R.id.idMensaje);
        mensaje();

    }

    private void mensaje(){
        Bundle extra = getIntent().getExtras();
        String mens = extra.getString("Mensaje");
        mensaje.setText(mens);
    }
}