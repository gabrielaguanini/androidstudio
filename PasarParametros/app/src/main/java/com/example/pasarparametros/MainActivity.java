package com.example.pasarparametros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nombre1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre1=(EditText)findViewById(R.id.nombre1);
    }

    //METODO PARA EL BOTON SIGUIENTE

    public void Enviar(View view){

        Intent intent_siguiente = new Intent (this, Main2Activity.class);

        //Para que pase el segundo parametro al 2do activity se usa el metodo putExtra() que toma 2 parametros
        // el primero es una "llave o key" de tipo string, recordar el nombre de la llave que puede ser cualquiera
        //el segundo es lo que se quiere enviar

        intent_siguiente.putExtra("dato_acvy1", nombre1.getText().toString());

        //arrabcar el siguiente activity

        startActivity(intent_siguiente);
    }
}