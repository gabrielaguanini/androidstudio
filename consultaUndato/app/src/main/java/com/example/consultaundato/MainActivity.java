package com.example.consultaundato;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    private EditText et_id, et_direccion, et_dni, et_nombre, et_salario, et_telefono;
    private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_id=findViewById(R.id.et_id);
        et_direccion=findViewById(R.id.et_direccion);
        et_dni=findViewById(R.id.et_dni);
        et_nombre=findViewById(R.id.et_nombre);
        et_salario=findViewById(R.id.et_salario);
        et_telefono=findViewById(R.id.et_telefono);

        rq= Volley.newRequestQueue(this);
    }

    public void consultar(View view){

        String url= "http://192.168.100.85:8080/buscardatosid/"+et_id.getText().toString();

        JsonObjectRequest requerimiento = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        try {

                            if(response.length()>0) {
                                et_direccion.setText(response.get("direccion").toString());
                                et_dni.setText(response.get("dni").toString());
                                et_nombre.setText(response.get("nombre").toString());
                                et_salario.setText(response.get("salario").toString());
                                et_telefono.setText(response.get("telefono").toString());
                            } else {
                                Toast.makeText(MainActivity.this,"no existe el id", Toast.LENGTH_LONG ).show();
                                et_direccion.setText("");
                                et_dni.setText("");
                                et_nombre.setText("");
                                et_salario.setText("");
                                et_telefono.setText("");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {

                      Toast.makeText(MainActivity.this,"no existe el id", Toast.LENGTH_LONG ).show();
                      Toast.makeText(MainActivity.this,error.getMessage(), Toast.LENGTH_LONG ).show();

                       et_id.setText("");
                       et_direccion.setText("");
                       et_dni.setText("");
                       et_nombre.setText("");
                       et_salario.setText("");
                       et_telefono.setText("");
            }
        });
        rq.add(requerimiento);
    }

}