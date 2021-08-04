package com.example.lab8pst;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activityDB extends AppCompatActivity {

    private EditText codigo,descripcion,precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        codigo=(EditText)findViewById(R.id.txtCodigo);
        descripcion=(EditText)findViewById(R.id.txtDescripcion);
        precio=(EditText)findViewById(R.id.txtPrecio);

    }
    public void ingresar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = codigo.getText().toString();
        String descri = descripcion.getText().toString();
        String pre = precio.getText().toString();
        bd.execSQL("insert into articulos (codigo,descripcion,precio) values ("+cod+",'"+descri+"',"+pre+")");
        bd.close();
        codigo.setText("");
        descripcion.setText("");
        precio.setText("");
        Toast.makeText(this, "Se cargaron los datos del artículo",
                Toast.LENGTH_SHORT).show();
    }
    public void consultaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        String cod = codigo.getText().toString();
        Cursor fila = bd.rawQuery(
                "select descripcion,precio from articulos where codigo=" + cod, null);
        if (fila.moveToFirst()) {
            Toast.makeText(this, "Consultando Codigo ...",
                    Toast.LENGTH_SHORT).show();
            descripcion.setText(fila.getString(0));
            precio.setText(fila.getString(1));
        } else
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void consultapordescripcion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        String descri = descripcion.getText().toString();
        Cursor fila = bd.rawQuery(
                "select codigo,precio from articulos where descripcion like '" + descri +"'", null);
        if (fila.moveToFirst()) {
            codigo.setText(fila.getString(0));
            precio.setText(fila.getString(1));
            Toast.makeText(this, "Consultando descripcion ...",
                    Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "No existe un artículo con dicha descripción",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void eliminar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= codigo.getText().toString();
        bd.execSQL("delete from articulos where codigo = "+cod);
        bd.close();
        codigo.setText("");
        descripcion.setText("");
        precio.setText("");
        Toast.makeText(this, "Se borró el artículo con dicho código",
                Toast.LENGTH_SHORT).show();
    }

    public void modificacion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = codigo.getText().toString();
        String descri = descripcion.getText().toString();
        String pre = precio.getText().toString();
        bd.execSQL("update articulos set codigo="+cod+",descripcion='"+descri+"',precio="+pre+" where codigo="+cod);
        bd.close();
        Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                .show();
    }



}