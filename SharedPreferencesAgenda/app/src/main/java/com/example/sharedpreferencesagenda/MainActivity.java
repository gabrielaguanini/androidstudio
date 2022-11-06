package com.example.sharedpreferencesagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;
    private EditText et_datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText) findViewById(R.id.txt_nombre);
        et_datos = (EditText) findViewById(R.id.txt_datos);

    }

    //BOTON GUARDAR

    public void Guardar(View view){
        String nombre = et_nombre.getText().toString();
        String datos = et_datos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(nombre,datos);
        obj_editor.commit();
        Toast.makeText(this, "El contacto se guardo", Toast.LENGTH_SHORT).show();
    }

    //BOTON BUSCAR

    public void Buscar(View view){
        String nombre2 = et_nombre.getText().toString();
        SharedPreferences preferencias2 = getSharedPreferences("agenda", Context.MODE_PRIVATE);

        String datos2= preferencias2.getString(nombre2, "");

        if(datos2.length()==0){
            Toast.makeText(this, "No se encontro ningun registro", Toast.LENGTH_SHORT).show();
        } else {
            et_datos.setText(datos2);
        }

    }

}