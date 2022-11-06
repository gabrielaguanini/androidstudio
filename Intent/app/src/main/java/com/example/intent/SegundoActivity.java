package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SegundoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
    }
    //METODO PARA EL BOTON ANTERIOR

    public void Anterior(View view){

        //Se instancia una clase de tipo INTENT, que recibe dos parametros 1° la clase de la que parte (this)
        //Segundo la parte a la que irá
        Intent intent_anterior = new Intent(this, MainActivity.class);

        //STARTACTIVITY lanza el activity al que se quiere ir

        startActivity(intent_anterior);
    }
}