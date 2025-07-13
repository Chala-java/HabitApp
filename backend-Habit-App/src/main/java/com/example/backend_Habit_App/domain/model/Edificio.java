package com.example.backend_Habit_App.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "edificio")
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edificio_id")
    protected Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name="valorAdministracion", nullable = false)
    private double valorAdministracion;
    @Column(name="numeroApartamento", nullable = false)
    private Integer numeroApartamento;
    @Column(name="pisos")
    private Integer pisos;

    @OneToMany(mappedBy = "edificio")
    @JsonManagedReference
    private List<Apartamento> apartamentos;

    public Edificio(){}

    public Edificio(Long id, String nombre, String direccion, double valorAdministracion, Integer numeroApartamento, Integer pisos, List<Apartamento> apartamentos) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.valorAdministracion = valorAdministracion;
        this.numeroApartamento = numeroApartamento;
        this.pisos = pisos;
        this.apartamentos = apartamentos;
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

    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(List<Apartamento> apartamentos) {
        this.apartamentos = apartamentos;
    }
}
