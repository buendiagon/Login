package com.example.moreno.logininfo.Entidades;

import java.util.Date;

public class usuario {

    private String documento;
    private String nombre;
    private String  fecha;
    private String email;
    private String user;

    public usuario(String documento, String nombre, String fecha, String email, String user) {
        this.documento = documento;
        this.nombre = nombre;
        this.fecha = fecha;
        this.email = email;
        this.user = user;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
