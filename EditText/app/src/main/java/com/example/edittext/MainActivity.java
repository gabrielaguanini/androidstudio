package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre=(EditText)findViewById(R.id.txt_nombre);
        etPass=(EditText)findViewById(R.id.txt_password);
    }

    //METODO PARA EL BOTON

    public void Registrar(View view){
        String nombre = etNombre.getText().toString();
        String password = etPass.getText().toString();

       if(nombre.length()==0){
          Toast.makeText(this, "Se debe ingresar un nombre", Toast.LENGTH_LONG).show();
       } if(password.length()==0){
           Toast.makeText(this, "Se debe ingresar una contraseña", Toast.LENGTH_LONG).show();
       } if (nombre.length()!=0  && password.length()!=0){
           Toast.makeText(this, "Registro en proceso", Toast.LENGTH_LONG).show();
       }
    }
}