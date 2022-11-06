package com.example.imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //METODO BOTON UTN

    public void MensajeGeekipedia(View view){
        Toast.makeText(this, "La Universidad Obrera Nacional", Toast.LENGTH_LONG).show();
    }

    //METODO BOTON HAMSA

    public void MensajeHamsa(View view){
        Toast.makeText(this, "Hamsa, hija de mahoma", Toast.LENGTH_LONG).show();
    }
}