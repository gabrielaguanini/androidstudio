package com.example.sharedpreferencespractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt_edit);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

        textView.setText(preferences.getString("nombre", ""));
   }
    //METODO BOTON ENVIAR

    public void Enviar2(View view){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("nombre", textView.getText().toString());
        editor.apply();
        finish();

    }
}
