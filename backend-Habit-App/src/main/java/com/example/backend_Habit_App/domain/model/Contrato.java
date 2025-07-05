package com.example.backend_Habit_App.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private double valorRenta;
    private String frecuenciaPago;
    private double deposito;


    @OneToOne
    @JoinColumn(name = "id_inquilino", referencedColumnName = "id")
    private Inquilino inquilino;

    @OneToOne
    @JoinColumn(name = "id_propietario", referencedColumnName = "id")
    private Propietario propietario;

    @OneToOne
    @JoinColumn(name = "id_apartamento", referencedColumnName = "id")
    private Apartamento apartamento;

    @OneToMany(mappedBy = "contrato")
    @JsonManagedReference
    private List<Pago> pagos;


    public Contrato() {
    }

    public Contrato(Long id, LocalDate fechaInicio, LocalDate fechaFin, String estado, double valorRenta, String frecuenciaPago, double deposito) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.valorRenta = valorRenta;
        this.frecuenciaPago = frecuenciaPago;
        this.deposito = deposito;
    }


}
