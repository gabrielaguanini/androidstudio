package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_codigo=(EditText) findViewById(R.id.txt_codigo);
        et_descripcion=(EditText) findViewById(R.id.txt_descripcion);
        et_precio=(EditText) findViewById(R.id.txt_precio);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //METODO BOTON REGISTRAR PRODUCTO (ALTA DE DATOS)

    public void Registrar(View view){

    // 1- CREAR UN OBJETO DE LA CLASE ADMINSQLITEOPENHELPER (CREADA PARA MANEJAR LA DATABASE)
    // ESTA CLASE RECIBE 4 PARAMETROS QUE SON EL CONTEXTO, NOMBRE DE LA DATABASE REAL (SE DIO UN NOMBRE PARA EL CONTEXTO EN LA ADMINSQLITEOPENHELPER,ESE NOMBRE NO SE USA ACA)
    // FACTORY (QUE DEBE SER NULL) Y EL NUMERO DE VERSION DE LA DATABASE (1 O LA PRIMERA DATABASE EN ESTE CASO)

         AdminSqLiteOpenHelper admin = new AdminSqLiteOpenHelper(this, "administracion", null, 1);

    // 2- ABRIR LA DATABASE EN MODO LECTURA Y ESCRITURA CON LA CLASE SQLITEDATABASE EL METODO GETWRITABLEDATABASE

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

    // 3 - MANTENER DATOS QUE EL USUARIO VAYA INGRESANDO

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

    // 4- VALIDACION DE CAMPOS Y PASAR DATOS DPS DE LA VALIDACION A LA DATABASE
        // LOS DATOS SE PASAN CON LA CLASE CONTENTVALUES Y EL METODO PUT. EL METODO PUT PIDE UN NUMBRE PARA LA VARIABLE EN DONDE SE TOMO
        //EL DATO QUE SE INGRESO EN EL CAMPO Y PIDE TAMBIEN EL NOMBRE DE ESA VARIABLE  registro.put("codigo", codigo);

        if(!codigo.isEmpty()&&!descripcion.isEmpty()&&!precio.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

    // 5 - PONER LOS VALORES ANTERIORES DENTRO DE LA TABLA CON EL METODO INSERT
            // EL METODO INSERT TOMA 3 PARAMETROS, EL 1° EL NOMBRE DE LA DATABASE DADO EN ADMINSQLITEOPENHELPER (QUE EN ESTE CASO ERA ARTICULOS)
            // EL 2° SIEMPRE ES NULL Y EL 3° LA INSTANCIA DE CONTENTVALUES (EN ESTE CASO SE LLAMO REGISTRO)

            BaseDeDatos.insert("articulos", null, registro);
            BaseDeDatos.close();
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");
            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //METODO PARA CONSULTA DE UN PRODUCTO O ARTICULO (CONSULTA DE DATOS)

    public void Buscar(View view){
        // 1- CREAR UN OBJETO DE LA CLASE ADMINSQLITEOPENHELPER (CREADA PARA MANEJAR LA DATABASE)
        // ESTA CLASE RECIBE 4 PARAMETROS QUE SON EL CONTEXTO, NOMBRE DE LA DATABASE REAL (SE DIO UN NOMBRE PARA EL CONTEXTO EN LA ADMINSQLITEOPENHELPER,ESE NOMBRE NO SE USA ACA)
        // FACTORY (QUE DEBE SER NULL) Y EL NUMERO DE VERSION DE LA DATABASE (1 O LA PRIMERA DATABASE EN ESTE CASO)

        AdminSqLiteOpenHelper admin = new AdminSqLiteOpenHelper(this, "administracion", null, 1);

        // 2- ABRIR LA DATABASE EN MODO LECTURA Y ESCRITURA CON LA CLASE SQLITEDATABASE EL METODO GETWRITABLEDATABASE

        SQLiteDatabase BaseDeDataBase = admin.getWritableDatabase();

        // 3 - RECUPERAR EL DATO CON EL QUE SE CONSULTARAN EL RESTO DE LOS DATOS (CODIGO DEL PRODUCTO EN ESTE CASO)

        String codigo = et_codigo.getText().toString();

        // 4 - VALIDACION DEL CAMPO CODIGO  , ACCEDER A LA BASE DE DATOS CON METODO "CURSOR"E INDICACION DE QUE COLUMNAS Y FILAS DEBE MOSTRAR EL CONTENIDO CON EL METODO RAWQUERY
        // CURSOR PROPORCIONA ACCESO ALEATORIO DE LECTURA Y ESCRITURA AL CONJUNTO DE RESULTADOS DEVUELTO POR UNA CONSULTA DE BASE DE DATOS
        // RAWQUERY TOMA 2 PARAMETROS, EL 1° ES UNA SENTENCIA SQL QUE UTILIZA EL NOMBRE DE LAS DOS COLUMNAS QUE CONTIENEN LOS DATOS (EN ESTE
        // CASO DESCRIPCION Y PRECIO) DE LA TABLA ARTICULOS (CREADA EN ADMINSQLITEOPENHELPER) Y EL SEGUNDO PARAMETRO ES NULL

        if(!codigo.isEmpty()){

            Cursor fila = BaseDeDataBase.rawQuery("select descripcion, precio from articulos where codigo=" + codigo, null);

            // 5- REVISAR SI LA CONSULTA ANTERIOR CONTIENE VALORES Y MOSTRARLOS SI LOS CONTIENE
            // EL METODO GETSTRING DE ET_DESCRIPCION Y ET_PRECIO TOMA COMO PARAMETRO UN 1 Y UN 0 RESPECTIVAMENTE, ESTOS
            // NUMEROS SE UTILIZAN PARA DAR ORDEN A LA LECTURA DE COLUMNA, DESCRIPCION ES UNA COLUMNA QUE ESTA PRIMERO QUE PRECIO
            // POR ESO DESCRIPCION TOMA UN 0 Y PRECIO UN 1, SI HUBIESE MAS COLUMNAS SE CONTINUARIA CON UN 2 Y UN 3, ETC.

            if( fila.moveToFirst()){
             et_descripcion.setText(fila.getString(0));
             et_precio.setText(fila.getString(1));
                BaseDeDataBase.close();
            } else {
                Toast.makeText(this, "no existe el artículo o producto", Toast.LENGTH_SHORT).show();
                BaseDeDataBase.close();
            }
        } else {
            Toast.makeText(this, "se debe ingresar un codigo", Toast.LENGTH_SHORT).show();

        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //METODO PARA BORRAR (BAJAS)

    public void Eliminar(View view){
        // 1- CREAR UN OBJETO DE LA CLASE ADMINSQLITEOPENHELPER (CREADA PARA MANEJAR LA DATABASE)
        // ESTA CLASE RECIBE 4 PARAMETROS QUE SON EL CONTEXTO, NOMBRE DE LA DATABASE REAL (SE DIO UN NOMBRE PARA EL CONTEXTO EN LA ADMINSQLITEOPENHELPER,ESE NOMBRE NO SE USA ACA)
        // FACTORY (QUE DEBE SER NULL) Y EL NUMERO DE VERSION DE LA DATABASE (1 O LA PRIMERA DATABASE EN ESTE CASO)

        AdminSqLiteOpenHelper admin = new AdminSqLiteOpenHelper(this, "administracion", null, 1);

        // 2- ABRIR LA DATABASE EN MODO LECTURA Y ESCRITURA CON LA CLASE SQLITEDATABASE EL METODO GETWRITABLEDATABASE

        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        // 3 - RECUPERAR EL DATO CON EL QUE SE ELIMINARAN O BORRARAN EL RESTO DE LOS DATOS (CODIGO DEL PRODUCTO EN ESTE CASO)

        String codigo = et_codigo.getText().toString();

        // 4 - VALIDACION DEL CAMPO, BUSCAR DATOS A BORRAR Y BORRARLOS

        if(!codigo.isEmpty()){

            // SE DECLARA UNA VARIABLE DE TIPO ENTERO PORQUE EL METODO DELETE RETORNA UN ENTERO QUE INDICA LA CANTIDAD DE REGISTROS BORRADOS
            // EL METODO DELETE TOMA 3 PARAMETROS, EL 1° DE CUAL TABLA BORRAR (ARTICULOS SE LLAMA EN ESTE CASO), EL 2° QUE BORRE EN ESTA TABLA
            // DONDE VEA EL CODIGO QUE INGRESO EL USUARIO EN EL CAMPO "CODIGO", EL 3° ES NULL

            int cantidad = BaseDatabase.delete("articulos", "codigo=" + codigo, null);
            BaseDatabase.close();
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            // MOSTRAR TOAST PARA INDICAR AL USUARIO SI SE ELIMINO O NO EL ARTICULO
            // EN LA SENTENCIA IF SE INDICA QUE SI EL METODO DELETE (UTILIZADO EN EL PASO ANTERIOR, RECORDAR QUE RETORNA UN NUMERO ENTERO QUE INDICA
            // LA CANTIDAD DE ELEMENTOS ELIMINADOS) RETORNA UNA CANTIDAD SIMILAR A 1, MUESTRE EL TOAST QUE DIGA "El articulo fue eliminado correctamente"
            // SINO MOSTRARÁ "El articulo no se pudo eliminar"

            if(cantidad == 1){
                Toast.makeText(this, "El articulo fue eliminado correctamente", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(this, "El articulo no se pudo eliminar", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Introducir codigo del articulo", Toast.LENGTH_SHORT).show();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //METODO PARA MODIFICAR UN PRODUCTO

    public void Modificar(View view){

        // 1- CREAR UN OBJETO DE LA CLASE ADMINSQLITEOPENHELPER (CREADA PARA MANEJAR LA DATABASE)
        // ESTA CLASE RECIBE 4 PARAMETROS QUE SON EL CONTEXTO, NOMBRE DE LA DATABASE REAL (SE DIO UN NOMBRE PARA EL CONTEXTO EN LA ADMINSQLITEOPENHELPER,ESE NOMBRE NO SE USA ACA)
        // FACTORY (QUE DEBE SER NULL) Y EL NUMERO DE VERSION DE LA DATABASE (1 O LA PRIMERA DATABASE EN ESTE CASO)

        AdminSqLiteOpenHelper admin = new AdminSqLiteOpenHelper(this, "administracion", null, 1);

        // 2- ABRIR LA DATABASE EN MODO LECTURA Y ESCRITURA CON LA CLASE SQLITEDATABASE EL METODO GETWRITABLEDATABASE

        SQLiteDatabase baseDatabase = admin.getWritableDatabase();

        // 3 - OBTENER LOS DATOS QUE EL USUARIO INGRESE EN LOS CAMPOS
        // SE GUARDAN LOS 3 CAMPOS PORQUE EL USUARIO PUEDE MODIFICAR CUALQUIERA DE ELLOS

        String codigo = et_codigo.getText().toString();
        String precio = et_precio.getText().toString();
        String descripcion = et_descripcion.getText().toString();

        //VALIDACION DE CAMPOS

        if(!codigo.isEmpty()&&!precio.isEmpty()&&!descripcion.isEmpty()){

            // 4- VALIDACION DE CAMPOS Y PASAR DATOS DPS DE LA VALIDACION A LA DATABASE
            // LOS DATOS SE PASAN CON LA CLASE CONTENTVALUES Y EL METODO PUT. EL METODO PUT PIDE UN NUMBRE PARA LA VARIABLE EN DONDE SE TOMO
            //EL DATO QUE SE INGRESO EN EL CAMPO Y PIDE TAMBIEN EL NOMBRE DE ESA VARIABLE  registro.put("codigo", codigo);

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("precio", precio);
            registro.put("descripcion", descripcion);

            // 5 - GUARDAR LO ANTERIOR EN LA DATABASE
            // EL METODO UPDATE TOMA 4 PARAMETROS, EL 1° EL NOMBRE DE LA TABLA (ARTICULOS EN ESTE CASO), 2° EL OBJETO DONDE SE GUARDARON LOS VALORES
            // (REGISTRO EN ESTE CASO), 3° LA SENTENCIA SQL QUE INDICA CON QUE DATO BUSCARA EL RESTO DE LOS DATOS Y EL 4° ES SIEMPRE NULL
            // EL METODO UPDATE RETORNA UN NUMERO ENTERO QUE INDICA CUANTOS REGISTROS SE MODIFICARON, EN ESTE CASO SERIA 1

            int cantidad = baseDatabase.update("articulos", registro, "codigo=" + codigo, null);
            baseDatabase.close();

            // 6- INDICAR SI SE MODIFICARON LOS DATOS O NO
            // cantidad==1 PORQUE LA VARIABLE REGISTRO RETORNA (POR EL USO DEL METODO UPDATE) LA CANTIDAD DE REGISTRO MODIFICADOS, EN ESTE CASO 1

            if(cantidad==1){
             Toast.makeText(this, "Articulo modificado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Articulo no modificado", Toast.LENGTH_SHORT).show();
            }

        } else{
            Toast.makeText(this, "debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }






    }


}