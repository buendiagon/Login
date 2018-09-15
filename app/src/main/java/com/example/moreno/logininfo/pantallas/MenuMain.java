package com.example.moreno.logininfo.pantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.moreno.logininfo.R;

public class MenuMain extends AppCompatActivity {
    String user;
    ImageView consultarMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        user=getIntent().getStringExtra("user");
        consultarMenu=findViewById(R.id.consultarID);


            consultarMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //pedir info para mostrar en pantalla

                    Intent pasar = new Intent(MenuMain.this,Consultas.class);
                    pasar.putExtra("user",user);
                    startActivity(pasar);
                }
            });

    }
}
