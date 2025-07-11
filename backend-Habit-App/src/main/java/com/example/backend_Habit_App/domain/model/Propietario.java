package com.example.backend_Habit_App.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "propietario")

public class Propietario extends UsuarioBase {

    @Column(name = "numero_cuenta", nullable = false)
    private long numero_cuenta;
    @Column(name = "metodo_pago", length = 20, nullable = false)
    private String metodo_pago;

    @OneToOne(mappedBy = "propietario")
    private Contrato contrato;

    public Propietario(){

    }

    public Propietario(Long id, String nombre, String apellido, String correo, String telefono, Long cedula, RolEnum rol, String contrasena, long numero_cuenta, String metodo_pago, Contrato contrato) {
        super(id, nombre, apellido, correo, telefono, cedula, rol, contrasena);
        this.numero_cuenta = numero_cuenta;
        this.metodo_pago = metodo_pago;
        this.contrato = contrato;
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

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
