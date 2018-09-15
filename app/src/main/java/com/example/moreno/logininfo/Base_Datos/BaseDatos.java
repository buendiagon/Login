package com.example.moreno.logininfo.Base_Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.moreno.logininfo.Entidades.usuario;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper{

    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table tb_usuarios(documento integer Primary key,nombre text,fecha text,email text,user text,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists tb_usuarios");
        db.execSQL("create table tb_usuarios(documento integer Primary key,nombre text,fecha text,email text,user text,password text)");

    }

    //crear 5 metodos

    public int insertar(Context context,ContentValues registro){
        BaseDatos baseDatos= new BaseDatos(context,"baseDatos",null, 1);
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        long exito;
        exito=db.insert("tb_usuarios",null, registro);
        if(exito==-1){
            return 0;
        }
        else {
            return 1;
        }

    }

    public int modificar(Context context,ContentValues registro,String user){
        BaseDatos baseDatos= new BaseDatos(context,"baseDatos",null, 1);
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        int exito;
        exito=db.update("tb_usuarios",registro,"user="+"'"+user+"'",null);
        if(exito==1){
            Toast.makeText(context, "bien", Toast.LENGTH_SHORT).show();
            return 1;
        }else {
            Toast.makeText(context, "mal", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    public  void eliminar(Context context,String user){
        BaseDatos baseDatos= new BaseDatos(context,"baseDatos",null, 1);
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        db.delete("tb_usuarios","user="+"'"+user+"'",null);
    }


//    ArrayList<usuario>lista;
//
//    public  void consulta(Context context,String id,ArrayList<usuario>lista){
//        this.lista=lista;
//        BaseDatos baseDatos= new BaseDatos(context,"baseDatos",null, 1);
//        SQLiteDatabase db = baseDatos.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select * from tb_usuarios where documento="+id,null);
//
//        if (cursor.moveToFirst()){
//            lista.add(new usuario(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)));
//        }
//        cursor.close();
//    }

    ArrayList<usuario>lista1;

    public  void consultaGeneral(Context context,ArrayList<usuario>lista1){
        this.lista1=lista1;
        BaseDatos baseDatos= new BaseDatos(context,"baseDatos",null, 1);
        SQLiteDatabase db = baseDatos.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_usuarios",null);

        while(cursor.moveToNext()){
            lista1.add(new usuario(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)));
        }
        cursor.close();
        db.close();
    }

    ArrayList<usuario>lista3;

    public  void consultaUser(Context context,String id,ArrayList<usuario>lista3){
        this.lista3=lista3;
        BaseDatos baseDatos= new BaseDatos(context,"baseDatos",null, 1);
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        try{
            Cursor cursor = db.rawQuery("select * from tb_usuarios where user="+"'"+id+"'",null);
            while (cursor.moveToNext()){

                lista3.add(new usuario(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)));
            }
            cursor.close();
        }catch (Exception z){
            Toast.makeText(context, "Este usuario no existe", Toast.LENGTH_SHORT).show();
        }







      db.close();
    }


}
