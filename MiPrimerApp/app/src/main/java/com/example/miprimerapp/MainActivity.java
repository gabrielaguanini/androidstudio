package com.example.miprimerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText ed1;
    private EditText ed2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= (EditText)findViewById(R.id.tx_num1);
        ed2 = (EditText)findViewById(R.id.txt_num2);
        tv1 = (TextView) findViewById(R.id.txt_resultado);
        }

        //ESTE METODO REALIZA LA SUMA

    public void Sumar(View view){
        String valor1 = ed1.getText().toString();
        String valor2= ed2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);

        int suma = num1 + num2;

        String resul= String.valueOf(suma);
        tv1.setText(resul);
    }
      }


