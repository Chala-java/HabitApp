package com.example.backend_Habit_App.domain.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class UsuarioBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected  Long id;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;

    protected String correo;
    @Column(name = "telefono", length = 20, nullable = false)
    private String telefono;
    @Column(name = "cedula",nullable = false)
    private Long cedula;
    @Column(name = "contrasena", length = 100, nullable = false)
    protected String contrasena;

    public  UsuarioBase(){

    }

    public UsuarioBase(Long id, String nombre, String apellido, String correo, String telefono, Long cedula, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
