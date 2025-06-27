package com.example.backend_Habit_App.domain.application.dto;

public class RegistroPropietarioDTO {

    private String correo;
    private String telefono;
    private Long cedula;
    private long numero_cuenta;
    private String metodo_pago;
    private String contrasena;

    public RegistroPropietarioDTO(){

    }

    public RegistroPropietarioDTO(String correo, String telefono, Long cedula, long numero_cuenta, String metodo_pago, String contrasena) {
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
        this.numero_cuenta = numero_cuenta;
        this.metodo_pago = metodo_pago;
        this.contrasena = contrasena;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
