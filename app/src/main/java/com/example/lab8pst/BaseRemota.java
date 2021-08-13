package com.example.lab8pst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class BaseRemota extends AppCompatActivity {
    private TextView queryText;
    private EditText query;
    private EditText Validacion;
    private String servidor= "192.168.100.193";
    private String ruta= "/android";
    private int puerto = 8080;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_remota);
        queryText = (TextView) findViewById(R.id.idQuery);
        query = (EditText) findViewById(R.id.idTabla);
        Validacion = (EditText) findViewById(R.id.idConsutaText);
    }

    public void Conectar(View v){
        String resultado = null;
        try {
            String url = "http://"+servidor+":"+puerto+ruta;
            AsyncQuery query = new AsyncQuery();
            resultado = query.execute(url).get();
            if (resultado!= null){
                queryText.setText(resultado);
            }else {
                queryText.setText("Error en Consulta");
            }
        }catch (ExecutionException ex){
            ex.printStackTrace();

        }catch (InterruptedException ex){
            ex.printStackTrace();

        }
    }
    public void consultar(View view){
        String resultado = null;
        String consulta1 = "Select * FROM "+query.getText().toString().trim();
        String validacion = Validacion.getText().toString().trim();
        String consulta2 = "Select * FROM "+query.getText().toString().trim()+" WHERE "+validacion;
        try {
            if (validacion.isEmpty()){
                String datos = "http://"+servidor+":"+puerto+"/android/"+consulta1;
                AsyncQuery async = new AsyncQuery();
                resultado = async.execute(datos).get();
                queryText.setText(resultado);
            }else {
                String datos = "http://"+servidor+":"+puerto+"/android/"+consulta2;
                AsyncQuery async = new AsyncQuery();
                resultado = async.execute(datos).get();
                queryText.setText(resultado);
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}