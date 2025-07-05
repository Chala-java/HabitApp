package com.example.backend_Habit_App.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador extends UsuarioBase{

    public Administrador(){}

    public Administrador(Long id, String nombre, String apellido, String correo, String telefono, Long cedula, String contrasena) {
        super(id, nombre, apellido, correo, telefono, cedula, contrasena);
    }

}
