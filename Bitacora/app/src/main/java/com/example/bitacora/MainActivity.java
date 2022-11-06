package com.example.bitacora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText et_bitac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_bitac = (EditText) findViewById(R.id.txt_bitacora);

        //FILELIST DEVUELVE UN ARRAY CON LOS FICHEROS ALMACENADOS POR LA APK, UN FICHERO ES UN TXT
        //CON EL METODO ARCHIVOEXISTE (QUE SE CREA MAS ADELANTE) EL FICHERO A RECUPERAR SE LLAMARA "bitacora.txt"

        String archivos [] = fileList();

        //ESTRUCTURA CONDICIONAL CON USO DE UN METODO BOOLEANO: archivoExiste es el nombre del metodo booleano
        //EL METODO ARCHIVO EXISTE DEBE TOMAR EL ARRAY "ARCHIVOS" QUE ES DONDE SE VAN A GUARDAR LOS TXT Y DARLE UN NOMBRE
        // UTILIZAR CON TRY AND CATCH

        if(ArchivoExiste(archivos, "bitacora.txt")) {

            try{

        //LA CLASE INPUTSTREAMREADER PERMITE ABRIR UN TXT PARA LEERLO
        //CON EL METODO OPENFILEINPUT ABRIMOS EL TXT, BITACORA.TXT EN ESTE CASO

            InputStreamReader archivo = new InputStreamReader(openFileInput("bitacora.txt"));

        // LA CLASE BUFFEREDREADER PERMITE LEER UN ARCHIVO QUE SE ABRIO PREVIAMENTE CON LA CLASE INPUTSTREAMREADER
                BufferedReader br = new BufferedReader(archivo);

        //INDICAR DONDE GUARDAR EL TEXTO QUE SE INGRESA EN LA INSTANCIA DE BUFFEREADER CREADA ANTERIORMENTE (ARCHIVO) CON LA CLASE READLINE
        // READLINE GUARDA LINEA X LINEA
                String linea = br.readLine();
                String bitacoraCompleta = "";

                while(linea != null){
                    bitacoraCompleta = bitacoraCompleta + linea + "\n";
                    linea=br.readLine();
                }
                br.close();
                archivo.close();
                et_bitac.setText(bitacoraCompleta);

                } catch (IOException e){

            }
        }
    }
//METODO BOOLEANO ARCHIVOEXISTE()
    private boolean ArchivoExiste(String archivos [], String NombreArchivo ){
        for(int i = 0; i < archivos.length; i++)
        if (NombreArchivo.equals(archivos[i]))
            return true;
        return false;
    }
//METODO PARA EL BOTON GUARDAR

    public void guardar(View view){
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("bitacora.txt", Activity.MODE_PRIVATE));
            archivo.write(et_bitac.getText().toString());
            archivo.flush();
            archivo.close();
        } catch (IOException e) {
        }
        Toast.makeText(this, "Bitacora guardada", Toast.LENGTH_SHORT).show();
        finish();
        }
    }

