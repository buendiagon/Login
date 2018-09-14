package com.example.moreno.logininfo.pantallas;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.moreno.logininfo.Base_Datos.BaseDatos;
import com.example.moreno.logininfo.Entidades.usuario;
import com.example.moreno.logininfo.MainActivity;
import com.example.moreno.logininfo.R;

import java.util.ArrayList;

public class Formulario extends AppCompatActivity {

    EditText nombrefor,documentofor,fechafor,emailfor,userfor,passwordfor;
    ImageView registrarse;

    ArrayList<usuario>lista;
    String[] corre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

            nombrefor=findViewById(R.id.nombreFor);
            documentofor=findViewById(R.id.documentoFor);
            fechafor=findViewById(R.id.fechaFor);
            emailfor=findViewById(R.id.emailFor);
            userfor=findViewById(R.id.userFor);
            passwordfor=findViewById(R.id.passwordFor);
            registrarse=findViewById(R.id.registrarFor);

            lista=new ArrayList<>();

            corre= new String[10];





                registrarse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ContentValues insertarFor = new ContentValues();

                        BaseDatos baseFormulario = new BaseDatos(Formulario.this,"baseDatos",null,1);
                        baseFormulario.consultaGeneral(Formulario.this,lista);
                        corre=emailfor.getText().toString().split("@");
                        int banderaCorre=0;

                        if (corre.length!=2){
                            banderaCorre=1;
                        }

                        int bandera=0;
                        try{

                           if (nombrefor.getText().toString().trim().isEmpty()||documentofor.getText().toString().trim().isEmpty()||fechafor.getText().toString().trim().isEmpty()
                                   ||fechafor.getText().toString().trim().isEmpty()||userfor.getText().toString().trim().isEmpty()||passwordfor.getText().toString().trim().isEmpty()){
                               Toast.makeText(Formulario.this, "Hay un campo vacio", Toast.LENGTH_SHORT).show();
                           }
                           else if(banderaCorre==1){
                               Toast.makeText(Formulario.this, "No es un correo valido", Toast.LENGTH_SHORT).show();

                           }
                           else{
                               int si=-1;

                               for (int i=0;i<lista.size();i++){

                                   if (userfor.getText().toString().equals(lista.get(i).getUser())){
                                       bandera=1;
                                   }
                               }
                                    if (bandera==0){
                                        insertarFor.put("documento",documentofor.getText().toString());
                                        insertarFor.put("nombre",nombrefor.getText().toString());
                                        insertarFor.put("fecha",fechafor.getText().toString());
                                        insertarFor.put("email",emailfor.getText().toString());
                                        insertarFor.put("user",userfor.getText().toString());
                                        insertarFor.put("password",passwordfor.getText().toString());

                                        si=baseFormulario.insertar(Formulario.this,insertarFor);

                                        Intent formularioMain = new Intent(Formulario.this, MainActivity.class);
                                        startActivity(formularioMain);
                                        if(si==1) {
                                            Toast.makeText(Formulario.this, "Te has registrado", Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            Toast.makeText(Formulario.this, "el documento se repite", Toast.LENGTH_SHORT).show();
                                        }
                                    }else{
                                        Toast.makeText(Formulario.this, "Este usuario ya existe", Toast.LENGTH_SHORT).show();
                                    }

                                    //por aqio

                           }
                       }catch (Exception z){
                           Toast.makeText(Formulario.this, "Error inesperado", Toast.LENGTH_SHORT).show();
                       }
                    }
                });
    }
}
