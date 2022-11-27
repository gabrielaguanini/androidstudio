package com.example.apiconexinsertar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private EditText etDireccion, etDni, etNombre, etSalario, etTelefono;
    private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDireccion=findViewById(R.id.etDireccion);
        etDni=findViewById(R.id.etDni);
        etNombre=findViewById(R.id.etNombre);
        etSalario=findViewById(R.id.etSalario);
        etTelefono=findViewById(R.id.etTelefono);
        rq= Volley.newRequestQueue(this);

    }

    public void insertar(View view){

        String url ="https://appdatabaseheroku.herokuapp.com/agregardatos";
        JSONObject parametros= new JSONObject();

        try {

            parametros.put("direccion", etDireccion.getText().toString());
            parametros.put("dni", etDni.getText().toString());
            parametros.put("nombre", etNombre.getText().toString());
            parametros.put("salario", etSalario.getText().toString());
            parametros.put("telefono", etTelefono.getText().toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest requerimiento = new JsonObjectRequest(Request.Method.POST,
                url,
                parametros,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {



                                   Toast.makeText(MainActivity.this, "Cargado correctamente", Toast.LENGTH_LONG).show();
                                     etDireccion.setText("");
                                     etDni.setText("");
                                     etNombre.setText("");
                                     etSalario.setText("");
                                     etTelefono.setText("");

                             }


                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                        Log.e("mira el error", error.toString());
                    }
                });
        rq.add(requerimiento);
   }
       }
