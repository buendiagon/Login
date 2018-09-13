package com.example.moreno.logininfo.Entidades;

import java.util.Date;

public class usuario {

    private Integer documento;
    private String nombre;
    private Date fecha;
    private String email;
    private String user;

    public usuario(Integer documento, String nombre, Date fecha, String email, String user) {
        this.documento = documento;
        this.nombre = nombre;
        this.fecha = fecha;
        this.email = email;
        this.user = user;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
