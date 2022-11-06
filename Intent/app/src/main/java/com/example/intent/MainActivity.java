package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //METODO PARA EL BOTON SIGUIENTE

    public void Siguiente(View view){

        //Se instancia una clase de tipo INTENT, que recibe dos parametros 1° la clase de la que parte (this)
        //Segundo la parte a la que irá
        Intent intent_siguiente = new Intent(this, SegundoActivity.class);

        //STARTACTIVITY lanza el activity al que se quiere ir
        startActivity(intent_siguiente);
    }
}