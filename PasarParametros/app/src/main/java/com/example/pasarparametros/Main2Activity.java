package com.example.pasarparametros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public TextView nombre2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre2 = (TextView) findViewById(R.id.nombre2);

        //TOMAR EL NOMBRE DE LA ACTIVITY1 CUANDO SE EJECUTE ONCREATE
        //El metodo GETSTRINGEXTRA() toma 1 parametro que es el nombre de la llave o key del activity1 ("dato_acvy1" en este caso)

        String dato_recibido_acvy1 = getIntent().getStringExtra("dato_acvy1");
        nombre2.setText("Hola " + dato_recibido_acvy1);
    }

    //METODO PARA EL BOTON REGRESAR

    public void Regresar(View view) {
        Intent intent_regresar = new Intent(this, MainActivity.class);
        startActivity(intent_regresar);
    }
}