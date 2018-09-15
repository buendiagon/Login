package com.example.moreno.logininfo.pantallas;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.moreno.logininfo.R;

public class ModificarUsuario extends AppCompatActivity {

    String usuari;
    EditText documento,nombre,fecha,email,user,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_usuario);
        usuari=getIntent().getStringExtra("user");
        documento=findViewById(R.id.documentoConsulta);
        nombre=findViewById(R.id.nombreConsulta);
        fecha=findViewById(R.id.fechaConsulta);
        email=findViewById(R.id.emailConsulta);
        user=findViewById(R.id.userConsulta);
        password=findViewById(R.id.passwordConsulta);


        ContentValues modificarUsu = new ContentValues();

    }
}
