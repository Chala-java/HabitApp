package com.example.backend_Habit_App.domain.models;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class UsuarioBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Integer id;

    @Column(name = "correo_base", nullable = false )
    protected Integer correo;

    @Column(name = "contrasena_base", nullable = false)
    protected Integer contrasena;

    public  UsuarioBase(){

    }

    public UsuarioBase(Integer id, Integer correo, Integer contrasena) {
        this.id = id;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCorreo() {
        return correo;
    }

    public void setCorreo(Integer correo) {
        this.correo = correo;
    }

    public Integer getContrasena() {
        return contrasena;
    }

    public void setContrasena(Integer contrasena) {
        this.contrasena = contrasena;
    }
}
