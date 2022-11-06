package com.example.miapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText ed1;
    private EditText ed2;
    private EditText ed3;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.txt_num1);
        ed2 = (EditText)findViewById(R.id.txt_num2);
        ed3 = (EditText)findViewById(R.id.txt_num3);
        tv1 = (TextView) findViewById(R.id.textView);
    }

    //ESTE METODO REALIZA EL PROMEDIO

    public void Promediar(View view){
        String valor1= ed1.getText().toString();
        String valor2= ed2.getText().toString();
        String valor3= ed3.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);
        int num3 = Integer.parseInt(valor3);

        int prom= (num1+num2+num3)/3;

        if (prom >= 6){
        tv1.setText("Alumno aprobado con " + prom);
    }
        else if (prom <6){
            tv1.setText("Alumno reprobado con " + prom);
        }
    }
}