package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityWeb extends AppCompatActivity {

    //COMO ESTE WEBVIEW MOSTRARA UNA PAGINA WEB, EL MODIFICADOR DE ACCESO NO PUEDE SER PRIVATE,
    // DE HECHO NO SE DECLARA NINGUN MODIFICADOR

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wv1=(WebView)findViewById(R.id.webView1);

        //RECUPERAR LA URL INGRESADA EN EL ACTIVITY 1

        String url = getIntent().getStringExtra("dato_url");

        //ABRIR LA URL EN EL WEBVIEW Y NO EN NAVEGADOR

        wv1.setWebViewClient(new WebViewClient());
        //SE AGREGAR EL HTTP XQ EL USUARIO INGRESARIA SOLO WWW.GOOGLE.COM, POR EJEMPLO
        wv1.loadUrl("http://" + url);
    }

    //METODO CERRAR

    public void Cerrar(View view){
        //EL METODO finish CIERRA EL SEGUNDO ACTIVITY Y VUELVE AL ANTERIOR

        finish();
    }
}