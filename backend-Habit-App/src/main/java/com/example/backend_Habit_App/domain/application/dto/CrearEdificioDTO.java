package com.example.backend_Habit_App.domain.application.dto;

public class CrearEdificioDTO {
    private String nombre;
    private String direccion;
    private double valorAdministracion;
    private Integer numeroApartamento;
    private Integer pisos;

    public CrearEdificioDTO() {
    }

    public CrearEdificioDTO(String nombre, String direccion, double valorAdministracion, Integer numeroApartamento, Integer pisos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.valorAdministracion = valorAdministracion;
        this.numeroApartamento = numeroApartamento;
        this.pisos = pisos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getValorAdministracion() {
        return valorAdministracion;
    }

    public void setValorAdministracion(double valorAdministracion) {
        this.valorAdministracion = valorAdministracion;
    }

    public Integer getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(Integer numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public Integer getPisos() {
        return pisos;
    }

    public void setPisos(Integer pisos) {
        this.pisos = pisos;
    }
}
