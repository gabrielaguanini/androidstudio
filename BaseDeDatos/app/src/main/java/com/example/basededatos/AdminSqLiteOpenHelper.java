package com.example.basededatos;

// 1 - CREAR ESTA MISMA JAVACLASS ( AdminSqLiteOpenHelper)
// 2 - IMPORTAR LA CLASE SQLITEOPENHELPER
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// 3 - EXTENDER LA CLASE SQLITEOPENHELPER (DARÁ ERROR HASTA QUE SE SOBREESCRIBAN DOS METODOS
// ONCREATE Y ONUPGRADE

// 4 - SOBRE LA LINEA DEL ERROR (public class AdminSqLiteOpenHelper extends SQLiteOpenHelper) ALT+ENTER
// SELECCIONAR IMPLEMENTS METHODS Y SELECCIONAR ONCREATE Y ONUPGRADE (QUE SE DEBEN SOBREESCRIBIR)

// 5 - SEGUIRÁ DANDO ERROR, SOBRE ESE ERROR ALT+ENTER Y SELECCIONAR CREAR CONSTRUCTOR (SELECCIONAR EL QU
// TIENE 4 PARAMETROS: CONTEXT NAME FACTORY VERSION )

public class AdminSqLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSqLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


// 6- SI SE QUIERE SE CAMBIA EL NOMBRE PREDETERMINADO DE LA DATABASE QUE ES sqLiteDatabase, EN ESTE EJEMPLO LE CAMBIO EL NOMBRE X BASEDEDATOS
// ESTE NOMBRE NO SERÁ EL QUE SE USARÁ, ES SOLO PARA DARLE CONTEXTO
// public void onCreate(SQLiteDatabase sqLiteDatabase ---- >ESTE NOMBRE ES EL PREDETERMINADO DE LA DATABASE) {

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {

        // 7 - SE CREA LA TABLA DONDE SE GUARDARAN LOS DATOS CON EL METODO execSQL()
        //  BaseDeDatos.execSQL("create table articulos(codigo int primary key, descripcion text, precio real )");
        //  ARTICULOS ES EL NOMBRE QUE LE DOY YO A LA TABLA. codigo int primary key, descripcion text, precio real son los nombres
        //  de las columnas con los tipos de datos que iran en ellas

        BaseDeDatos.execSQL("create table articulos(codigo int primary key, descripcion text, precio real )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
