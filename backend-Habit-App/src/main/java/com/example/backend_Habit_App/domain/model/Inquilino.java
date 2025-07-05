package com.example.backend_Habit_App.domain.model;

import jakarta.persistence.*;

import java.security.PublicKey;

@Entity
@Table(name = "inquilino")
public class Inquilino extends UsuarioBase {

    public Inquilino(){

    }

    public Inquilino(Long id, String nombre, String apellido, String correo, String telefono, Long cedula, String contrasena) {
        super(id, nombre, apellido, correo, telefono, cedula, contrasena);
    }
}
