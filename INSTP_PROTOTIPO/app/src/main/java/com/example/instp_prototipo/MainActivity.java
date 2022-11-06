package com.example.instp_prototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText) findViewById(R.id.edtxt_nombreingresar);
    }
    //METODO PARA EL BOTON CONTINUAR

    public void Continuar(View view) {

        Intent intent_acvy2 = new Intent(this, ActivityCarrera.class);

        intent_acvy2.putExtra("dato_acvy2", et_nombre.getText().toString());

        startActivity(intent_acvy2);
    }
}