package com.example.backend_Habit_App.domain.application.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EdificioDTO {

    protected Long id;
    private String nombre;
    private String direccion;
    private double valorAdministracion;
    private Integer numeroApartamento;
    private Integer pisos;

    public EdificioDTO() {
    }

    public EdificioDTO(Long id, String nombre, String direccion, double valorAdministracion, Integer numeroApartamento, Integer pisos) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.valorAdministracion = valorAdministracion;
        this.numeroApartamento = numeroApartamento;
        this.pisos = pisos;
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
