package com.example.apiconexion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=findViewById(R.id.tv1);
        tv1.setMovementMethod(new ScrollingMovementMethod());
        rq= Volley.newRequestQueue(this);
    }

    public void recuperar(View view){
        tv1.setText("");
        String url="https://appdatabaseheroku.herokuapp.com/listadatosper";

        JsonArrayRequest requerimiento = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                     for(int f=0; f<response.length(); f++){
                         try {
                             JSONObject objeto = new JSONObject(response.get(f).toString());
                             tv1.append("____________________________\n");
                             tv1.append("Direccion: "+ objeto.getString("direccion")+"\n");
                             tv1.append("Dni: "+ objeto.getString("dni")+"\n");
                             tv1.append("Nombre: "+ objeto.getString("nombre")+"\n");
                             tv1.append("Salario: "+ objeto.getString("salario")+"\n");
                             tv1.append("Telefono: "+ objeto.getString("telefono")+"\n");

                         } catch (JSONException e) {
                             e.printStackTrace();
                         }
                     }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        rq.add(requerimiento);
    }
}