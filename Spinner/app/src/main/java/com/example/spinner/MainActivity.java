package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1;
    private EditText et2;

    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //relacion entre grafico y logica

        spinner1=(Spinner)findViewById(R.id.spinner);

        et1= (EditText)findViewById(R.id.txt_valor1);
        et2= (EditText)findViewById(R.id.txt_valor2);

        tv1= (TextView)findViewById(R.id.tv_resultado);


        //SPINNER -> strings que seran opciones con array

        String [] opciones = {"Selecciona","sumar","restar", "multiplicar", "dividir"};
        

        //SPINNER -> PONER ARREGLO OPCIONES DENTRO DEL SPINNER CON CLASE ARRAYADAPTER
        // (this --> contexto donde se va a mostrar la clase ArrayAdapter llamada adapter en este caso,
        // android.R.layout.simple_spinner_item --> el tipo/diseño del spinner ,
        // opciones --> el array con las palabras que van adentro del spinner);

        ArrayAdapter <String> adapter= new ArrayAdapter<String>(this, R.layout.spinner_item_geekipedia, opciones);
        spinner1.setAdapter(adapter);


    }
       //METODO DEL BOTON

       public void Calcular(View view){
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);


        //SABER QUE OCPION SE ELIGIO DEL SPINNER

        String seleccion = spinner1.getSelectedItem().toString();

        if(seleccion.equals("sumar")){
            int suma= valor1_int+valor2_int;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
           }
       else if(seleccion.equals("restar")){
            int resta= valor1_int-valor2_int;
            String resultado2 = String.valueOf(resta);
            tv1.setText(resultado2);
           }
       else if(seleccion.equals("multiplicar")){
           int multiplica= valor1_int*valor2_int;
           String resultado3= String.valueOf(multiplica);
           tv1.setText(resultado3);
           }
       else if(seleccion.equals("dividir")){
            if(valor2_int==0){
                Toast.makeText(this, "Ingresar valor diferente a 0", Toast.LENGTH_LONG).show();
                et2.setText("");
            } else {

                int divide = valor1_int / valor2_int;
                String resultado4 = String.valueOf(divide);
                tv1.setText(resultado4);
            }

           }
       }
}