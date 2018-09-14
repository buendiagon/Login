package com.example.moreno.logininfo.pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.moreno.logininfo.Adaptadores.Adaptadores_java;
import com.example.moreno.logininfo.Entidades.usuario;
import com.example.moreno.logininfo.R;

import java.util.ArrayList;

public class ConsultaGeneral extends AppCompatActivity {


ArrayList<usuario>lista;
RecyclerView recyclerView;
Adaptadores_java adaptadores_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_general);
        lista=new ArrayList<>();
        recyclerView=findViewById(R.id.contenedor);

            for (int i=0;i<=60;i++){
                lista.add(new usuario("120","Edward","05/10/20","buendia@pereza.com","buendia"));
            }

        adaptadores_java=new Adaptadores_java(lista);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptadores_java);
    }

}
