package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.txt_mail);

        // PARA GUARDAR LOS DATOS DEL TEXT VIEW CREAR OBJETO SE TIPO SHAREDPREFERENCES CON EL METODO GETSHAREDPREFERENCES,
        // QUE PIDE DOS ARGUMENTOS
        // EL PRIMERO, EL NOMBRE QUE SE LE DARA AL ARCHIVO DONDE SE ALMACENARAN LOS DATOS Y EL SEGUNDO

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

        //COLOCAR LO QUE HAYA ENCONTRADO CON GETSHAREDPREFERENCES
        //EL STRING MAIL ES SOLO UN NOMBRE DE REFERENCIA Y LAS COMILLAS SON XQ CUANDO ARRANCA APK X PRIMERA VEZ NO VA A HABER NADA
        //PERO MAS ADELANTE SI

        et1.setText(preferences.getString("mail", "" ));

    }

    //MÉTODO DEL BOTON


    public void Guardar(View view){
    //cada vez que se aprete el boton se tiene que crear un objeto SharedPreference ademas del creado en el metodo OnCreate

       SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);

    //clase editor para editar el archivo datos creado con SharedPreferences

    SharedPreferences.Editor obj_editor = preferencias.edit();

    //colocar los valores dentro del archivo de referencia "mail" creado con  et1.setText(preferences.getString("mail", "" ))
    // dentro del metodo OnCreate

        obj_editor.putString("mail", et1.getText().toString());
        obj_editor.commit();
        finish();

    }
}