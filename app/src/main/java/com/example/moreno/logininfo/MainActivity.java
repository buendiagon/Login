package com.example.moreno.logininfo;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moreno.logininfo.Base_Datos.BaseDatos;
import com.example.moreno.logininfo.Entidades.usuario;
import com.example.moreno.logininfo.pantallas.ConsultaGeneral;
import com.example.moreno.logininfo.pantallas.MenuMain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

EditText usuarioMai,passwordMai;
ImageView ingresarMai,resgistrarMai;
ArrayList<usuario>listaU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioMai=findViewById(R.id.usuarioMain);
        passwordMai=findViewById(R.id.passwordMain);
        ingresarMai=findViewById(R.id.ingresarID);
        resgistrarMai=findViewById(R.id.registrarID);BaseDatos baseDatos=new BaseDatos(MainActivity.this,"baseDatos",null,1);

        for (int i=0;i<=60;i++){
            ContentValues registro=new ContentValues();
            registro.put("documento",String.valueOf(i));
            registro.put("nombre","Zapata");
            registro.put("fecha","02-03-98");
            registro.put("email","adasd@hotmail.com");
            registro.put("user","zapa"+String.valueOf(i));
            registro.put("password","asdad");
            baseDatos.insertar(MainActivity.this,registro);
        }

        listaU=new ArrayList<>();
            ingresarMai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    BaseDatos baseMain = new BaseDatos(MainActivity.this,"baseDatos",null,1);
                            baseMain.consultaUser(MainActivity.this,usuarioMai.getText().toString(),listaU);


                            if (listaU.isEmpty()){
                                Toast.makeText(MainActivity.this, "este usuario no existe", Toast.LENGTH_SHORT).show();
                            } else{
                                if(passwordMai.getText().toString().equals(listaU.get(0).getPassword())){
                                    Intent menuu = new Intent(MainActivity.this, MenuMain.class);
                                    startActivity(menuu);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "Contraseña no valida", Toast.LENGTH_SHORT).show();
                                }
                            }




                }
            });

    }
}
