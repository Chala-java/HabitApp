package com.example.backend_Habit_App.domain.application.dto;

public class IniciarSesionDTO {

    private String correo;
    private String contrasena;

    public IniciarSesionDTO(){}

    public IniciarSesionDTO(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
