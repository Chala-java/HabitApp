package com.example.backend_Habit_App.domain.model;

import jakarta.persistence.*;

import java.security.PublicKey;

@Entity
@Table(name = "inquilino")
public class Inquilino extends UsuarioBase {


    @OneToOne(mappedBy = "inquilino")
    private Contrato contrato;

    public Inquilino(){

    }

    public Inquilino(Contrato contrato) {
        this.contrato = contrato;
    }

    public Inquilino(Long id, String nombre, String apellido, String correo, String telefono, Long cedula, RolEnum rol, String contrasena, Contrato contrato) {
        super(id, nombre, apellido, correo, telefono, cedula, rol, contrasena);
        this.contrato = contrato;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
