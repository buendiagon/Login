package com.example.moreno.logininfo.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moreno.logininfo.Entidades.usuario;
import com.example.moreno.logininfo.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Adaptadores_java extends RecyclerView.Adapter<Adaptadores_java.listViewHolder> {

ArrayList<usuario>lista;

    public Adaptadores_java(ArrayList<usuario> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public Adaptadores_java.listViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,null,false);
        return new listViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Adaptadores_java.listViewHolder listViewHolder, int i) {
        listViewHolder.email.setText(lista.get(i).getEmail());
        listViewHolder.nombre.setText(lista.get(i).getNombre());
        listViewHolder.user.setText(lista.get(i).getUser());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    class listViewHolder extends RecyclerView.ViewHolder {

        TextView nombre,email,user;


        public listViewHolder(@NonNull View itemView) {
            super(itemView);
            email=itemView.findViewById(R.id.emailGeneral);
            nombre=itemView.findViewById(R.id.nombreGeneral);
            user=itemView.findViewById(R.id.userGeneral);
        }
    }


}
