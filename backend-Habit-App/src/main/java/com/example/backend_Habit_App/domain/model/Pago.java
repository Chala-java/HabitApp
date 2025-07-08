package com.example.backend_Habit_App.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name="fecha", nullable = false)
    private LocalDate fecha;
    @Column(name = "montoTotal")
    private double montoTotal;
    @Column(name="fotoComprobante")
    private String fotoComprobante;
    @Column(name="estado_validacion")
    private PagoEnum estadoValidacion;

    @ManyToOne
    @JoinColumn(name="fk_contrato", referencedColumnName = "contrato_id")
    @JsonBackReference Contrato contrato;
}
