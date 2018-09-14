package com.example.moreno.logininfo.Base_Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper{

    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table tb_usuarios(documento Integer Primary key,nombre text,fecha text,email,text,user text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists tb_usuarios");
        db.execSQL("create table tb_usuarios(documento Integer Primary key,nombre text,fecha text,email,text,user text)");

    }

    //crear 5 metodos

    public  void insertar(Context context,ContentValues registro){
        BaseDatos baseDatos= new BaseDatos(context,"baseDatos",null, 1);
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        db.insert("tb_usuarios",null, registro);

    }

    public  void modificar(Context context){
        BaseDatos baseDatos= new BaseDatos(context,"baseDatos",null, 1);
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        
    }

    public  void eliminar(){

    }

    public  void consulta(){

    }

    public  void insertarGeneral(){

    }



}
