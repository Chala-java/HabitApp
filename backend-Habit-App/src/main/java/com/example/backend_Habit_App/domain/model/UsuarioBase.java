package com.example.backend_Habit_App.domain.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class UsuarioBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Long id;

    @Column(name = "correo", length = 200, nullable = false )
    protected String correo;
    @Column(name = "telefono", length = 20, nullable = false)
    private String telefono;
    @Column(name = "cedula",nullable = false)
    private Long cedula;
    @Column(name = "contrasena", length = 100, nullable = false)
    protected String contrasena;

    public  UsuarioBase(){

    }

    public UsuarioBase(Long id, String correo, String telefono, Long cedula, String contrasena) {
        this.id = id;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
        this.contrasena = contrasena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
