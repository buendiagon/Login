package com.example.moreno.logininfo.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.moreno.logininfo.Base_Datos.BaseDatos;
import com.example.moreno.logininfo.Entidades.usuario;
import com.example.moreno.logininfo.R;

import java.util.ArrayList;

public class Consultas extends AppCompatActivity {
    String usuari;
    TextView documento,nombre,fecha,correo,user;
    ArrayList<usuario>listaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        usuari=getIntent().getStringExtra("user");
        documento=findViewById(R.id.dcomuentoID);
        nombre=findViewById(R.id.nombreID);
        fecha=findViewById(R.id.fechaID);
        correo=findViewById(R.id.emailID);
        user=findViewById(R.id.userID);

        listaC =new ArrayList<>();

        BaseDatos baseConsulta = new BaseDatos(Consultas.this,"baseDatos",null,1);
        baseConsulta.consultaUser(Consultas.this,usuari,listaC);
        documento.setText(listaC.get(0).getDocumento());
        nombre.setText(listaC.get(0).getNombre());
        fecha.setText(listaC.get(0).getFecha());
        correo.setText(listaC.get(0).getEmail());
        user.setText(listaC.get(0).getUser());




    }
}
