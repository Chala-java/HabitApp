package com.example.backend_Habit_App.domain.application.dto;

import com.example.backend_Habit_App.domain.model.RolEnum;

public class IniciarSesionAdminDTO {
    private String correo;
    private String contrasena;

    private RolEnum rol;

    public IniciarSesionAdminDTO(String correo, String contrasena, RolEnum rol) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
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

    public RolEnum getRol() {
        return rol;
    }

    public void setRol(RolEnum rol) {
        this.rol = rol;
    }
}
