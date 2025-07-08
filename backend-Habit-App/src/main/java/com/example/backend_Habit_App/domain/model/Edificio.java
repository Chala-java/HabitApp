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

}
