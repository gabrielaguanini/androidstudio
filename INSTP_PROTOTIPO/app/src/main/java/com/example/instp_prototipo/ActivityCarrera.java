package com.example.instp_prototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ActivityCarrera extends AppCompatActivity {
       private TextView nombreAcvy2;
       private ListView listaCarreras;

       private String carreras []={"Profesorado en Disciplinas Industriales",
                                  "Informática Aplicada", "Control Electrico y Accionamientos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera);

        //NOMBRE + BIENVENIDA
        nombreAcvy2 = (TextView) findViewById(R.id.txt_view_Nom2act);
        String dato_rec_acty1 = getIntent().getStringExtra("dato_acvy2");
        nombreAcvy2.setText("Hola " + dato_rec_acty1);

        //ARRAYADAPTER PARA COLOCAR ARRAY CARRERAS DENTRO DEL LISTVIEW
        listaCarreras = (ListView) findViewById(R.id.lVCarreras);

        ArrayAdapter <String> adapter_lv_carreras = new ArrayAdapter<>(this, R.layout.list_view_layout, carreras);
        listaCarreras.setAdapter(adapter_lv_carreras);

    }

    public void Regresar(View view){
        finish();
    }
}