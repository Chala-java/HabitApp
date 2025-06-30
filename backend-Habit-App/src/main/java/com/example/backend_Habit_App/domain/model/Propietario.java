package com.example.backend_Habit_App.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "propietario")

public class Propietario extends UsuarioBase {

    @Column(name = "numero_cuenta", nullable = false)
    private long numero_cuenta;
    @Column(name = "metodo_pago", length = 20, nullable = false)
    private String metodo_pago;


    public Propietario(){

    }

    public Propietario(long numero_cuenta, String metodo_pago) {
        this.numero_cuenta = numero_cuenta;
        this.metodo_pago = metodo_pago;
    }

    public Propietario(Long id, String nombre, String apellido, String correo, String telefono, Long cedula, String contrasena, long numero_cuenta, String metodo_pago) {
        super(id, nombre, apellido, correo, telefono, cedula, contrasena);
        this.numero_cuenta = numero_cuenta;
        this.metodo_pago = metodo_pago;
    }

    public long getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(long numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
}
