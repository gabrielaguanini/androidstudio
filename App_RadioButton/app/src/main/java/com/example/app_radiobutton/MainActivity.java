package com.example.app_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private RadioButton rb_suma, rb_resta, rb_multi, rb_divi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1= (EditText)findViewById(R.id.txt_valor1);
        et2= (EditText)findViewById(R.id.txt_valor2);

        tv1= (TextView)findViewById(R.id.txt_resultado);

        rb_suma= (RadioButton)findViewById(R.id.rb_sumar);
        rb_resta= (RadioButton)findViewById(R.id.rb_restar);
        rb_multi = (RadioButton) findViewById(R.id.rb_multiplicar);
        rb_divi= (RadioButton) findViewById(R.id.rb_dividir);
    }

    //METODO PARA EL BOTON CALCULAR

    public void Calcular(View view){
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        int valor1_Int = Integer.parseInt(valor1_String);
        int valor2_Int = Integer.parseInt(valor2_String);

        if (valor2_Int==0 & rb_divi.isChecked() == true){
            Toast.makeText(this, "Ingresar valor diferente a 0 cero", Toast.LENGTH_LONG).show();
        }  else if(rb_suma.isChecked() == true){
           int suma= valor1_Int+valor2_Int;
           String resultado = String.valueOf(suma);
           tv1.setText(resultado);
        } else if(rb_resta.isChecked() == true){
            int resta = valor1_Int - valor2_Int;
            String resultado2 = String.valueOf(resta);
            tv1.setText(resultado2);
        } else if(rb_multi.isChecked()==true){
            int multiplicacion = valor1_Int*valor2_Int;
            String resultado3 = String.valueOf(multiplicacion);
            tv1.setText(resultado3);
        }else if (rb_divi.isChecked() == true){
            int division = valor1_Int/valor2_Int;
            String resultado4 = String.valueOf(division);
            tv1.setText(resultado4);
        }
    }

}