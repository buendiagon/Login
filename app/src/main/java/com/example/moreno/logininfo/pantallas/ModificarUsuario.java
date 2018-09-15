package com.example.moreno.logininfo.pantallas;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moreno.logininfo.Base_Datos.BaseDatos;
import com.example.moreno.logininfo.Entidades.usuario;
import com.example.moreno.logininfo.MainActivity;
import com.example.moreno.logininfo.R;

import java.util.ArrayList;

public class ModificarUsuario extends AppCompatActivity {

    String usuari;
    EditText nombre,fecha,email,user,password;
    Button modificar;

//buscar anime btoom
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_usuario);
        usuari=getIntent().getStringExtra("user"); //intent.putExtra("user",usuari);
        nombre=findViewById(R.id.nombreConsulta);
        fecha=findViewById(R.id.fechaConsulta);
        email=findViewById(R.id.emailConsulta);
        user=findViewById(R.id.userConsulta);
        password=findViewById(R.id.passwordConsulta);
        modificar=findViewById(R.id.modicarID);



        final BaseDatos baseModificar = new BaseDatos(ModificarUsuario.this,"baseDatos",null,1);

        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContentValues modificarUsu = new ContentValues();
                int kawaii=0;

                if (!nombre.getText().toString().trim().isEmpty()){
                    modificarUsu.put("nombre",nombre.getText().toString());
                    kawaii=1;
                }

                if (!fecha.getText().toString().trim().isEmpty()){
                    modificarUsu.put("fecha",fecha.getText().toString());
                    kawaii=1;
                }
                if (!email.getText().toString().trim().isEmpty()){
                    modificarUsu.put("email",email.getText().toString());
                    kawaii=1;
                }
                if (!user.getText().toString().trim().isEmpty()){
                    modificarUsu.put("user",user.getText().toString());
                    kawaii=1;
                }
                if (!password.getText().toString().trim().isEmpty()){
                    modificarUsu.put("password",password.getText().toString());
                    kawaii=1;
                }
                if(kawaii==1) {

                    baseModificar.modificar(ModificarUsuario.this, modificarUsu, usuari);
                    Intent intent = new Intent(ModificarUsuario.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(ModificarUsuario.this, "Ingrese algun campo", Toast.LENGTH_SHORT).show();
                }

            }
        });







    }
}
