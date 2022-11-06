package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;





public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private ListView lv1;

    //ARRAY 1 PARA Q EL LISTVIEW MUESTRE LAS OPCIONES (NOMBRES EN ESTE CASO)
    private String nombres [] = {"Gabriela", "Juana", "Mariela", "Karina"};

    //ARRAY 2 PARA EL LISTVIEW MUESTRE ESTAS EDADES CUANDO SE SELECCIONE UNA OPCION
    // DEL ARRAY 1
    private String edades [] ={"36", "25", "17", "50"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView) findViewById(R.id.tv1);
        lv1=(ListView) findViewById(R.id.lv1);

        //PONER LOS ARRAY DEL ENCAPSULAMIENTO DENTRO DE LA CLASE LISTVIEW
        //LLAMADA ADAPTER

        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, R.layout.list_item_geekipedia, nombres);

        //MOSTRAR EN LA ACTIVITY LOS ELEMENTOS QUE METIMOS EN ADAPTER

        lv1.setAdapter(adapter);

        //MOSTRAR AL SELECCIONAR LOS NOMBRES LAS EDADES DEL SEGUNDO ARRAY. PARA ELLO SE NECESITA UNA CLASE ANONIMA QUE ANDROID NOS DA POR DEFECTO

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            tv1.setText("La edad de " + lv1.getItemAtPosition(i) + " es " + edades[i] + " años");
            }
        });


    }
}