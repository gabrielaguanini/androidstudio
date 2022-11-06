package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.txt_web);

    }

    //METODO BOTON 1

    public void Navegar(View view){
        Intent intent_AcvyWeb = new Intent(this, ActivityWeb.class);

        //Para que pase el segundo parametro al 2do activity se usa el metodo putExtra() que toma 2 parametros
        // el primero es una "llave o key" de tipo string, recordar el nombre de la llave que puede ser cualquiera
        //el segundo es el texto que se quiere enviar, en este caso encapsulado en et1

        intent_AcvyWeb.putExtra("dato_url", et1.getText().toString());
        startActivity(intent_AcvyWeb);
    }
}