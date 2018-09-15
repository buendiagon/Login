package com.example.moreno.logininfo.pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.moreno.logininfo.Base_Datos.BaseDatos;
import com.example.moreno.logininfo.MainActivity;
import com.example.moreno.logininfo.R;

public class MenuMain extends AppCompatActivity {
    String user;
    Button consultarMenu,modificar,general,eliminar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        user=getIntent().getStringExtra("user");
        consultarMenu=findViewById(R.id.consultarID);
        modificar=findViewById(R.id.modificarID);
        general=findViewById(R.id.generalID);
        eliminar=findViewById(R.id.eliminarID);

            consultarMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //pedir info para mostrar en pantalla

                    Intent pasar = new Intent(MenuMain.this,Consultas.class);
                    pasar.putExtra("user",user);
                    startActivity(pasar);
                    finish();
                }
            });

            modificar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent pasar = new Intent(MenuMain.this,ModificarUsuario.class);
                    pasar.putExtra("user",user);
                    startActivity(pasar);
                    finish();
                }
            });

            general.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent pasar = new Intent(MenuMain.this,ConsultaGeneral.class);
                    startActivity(pasar);
                    finish();
                }
            });

            eliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //llamar bd y metodo eliminar
                    BaseDatos baseEliminar = new BaseDatos(MenuMain.this,"baseDatos",null,1);
                    baseEliminar.eliminar(MenuMain.this,user);
                    Intent pasar = new Intent(MenuMain.this,MainActivity.class);
                    pasar.putExtra("user",user);
                    startActivity(pasar);
                    finish();
                }
            });


    }
}
