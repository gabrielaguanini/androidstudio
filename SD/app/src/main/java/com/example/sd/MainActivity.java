package com.example.sd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre=(EditText)findViewById(R.id.txt_nombre);
        et_contenido=(EditText)findViewById(R.id.txt_contenido);
    }
//METODO BOTON GUARDAR

    public void Guardar(View view){
        String nombre = et_nombre.getText().toString();
        String contenido = et_contenido.getText().toString();

        try {

            //GUARDAR DONDE ESTA LA TARJETA SD CON LA CLASE FILE, ENCONTRARLA CON LA CLASE ENVIRONMENT Y EL MÉTODO
            //getExternalStorageDirectory()

            File tarjetaSd = Environment.getExternalStorageDirectory();

            //TOAST PARA VER LA RUTA DONDE SE VA A GUARDAR EL ARCHIVO CON EL MÉTODO getPath()
            Toast.makeText(this, tarjetaSd.getPath(), Toast.LENGTH_SHORT).show();

            //GUARDAR EL ARCHIVO CREADO CON LA CLASE FILE, los dos argumentos son el path y el nombre que
            //selecciono el usuario
            File rutaArchivo = new File(tarjetaSd.getPath(), nombre);

            //ABRIR EL ARCHIVO PARA ESCRIBIR CON LA CLASE OUTPUTSTREAMWRITER y su metodo OPENFILEOUTPUT

            OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(nombre, Activity.MODE_PRIVATE));

            //INDICAR DONDE GUARDAR EL CONTENIDO ESCRITO
            crearArchivo.write(contenido);
            crearArchivo.flush();
            crearArchivo.close();
            Toast.makeText(this, "Guardado correctamente", Toast.LENGTH_SHORT).show();
            et_nombre.setText("");
            et_contenido.setText("");


        } catch(IOException e){
            Toast.makeText(this, "No se guardo", Toast.LENGTH_SHORT).show();
        }
    }
//METODO BOTON CONSULTAR

    public void Consultar(View view){

       String nombre = et_nombre.getText().toString();

        try{
        // OBTENER EL PATH DONDE ESTA EL ARCHIVO
        File tarjetaSD = Environment.getExternalStorageDirectory();
        File rutaArchivo = new File(tarjetaSD.getPath(), nombre);

        //ABRIR EL ARCHIVO PARA LEERLO
        InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(nombre));
        //VERIFICAR QUE TENGA CONTENIDO Y LEER LINEA X LINEA
            BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
        //LEER LA PRIMERA LENA DE TEXTO DEL ARCHIVO
            String linea = leerArchivo.readLine();
        //LEER LAS SIGUIENTES LINEAS, GUARDARLAS Y VERIFICAR QUE NO ESTEN VACIAS LAS LINEAS
        String contenidoCompleto = "";

        while(linea != null){
            contenidoCompleto= contenidoCompleto + linea + "\n";
            linea = leerArchivo.readLine();
        }
         leerArchivo.close();
        abrirArchivo.close();
        et_contenido.setText(contenidoCompleto);


        } catch(IOException e){

            Toast.makeText(this, "Error al consultar", Toast.LENGTH_SHORT).show();
        }
    }


}