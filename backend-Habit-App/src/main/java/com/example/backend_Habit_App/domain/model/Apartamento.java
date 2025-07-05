package com.example.backend_Habit_App.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "numero", nullable = false)
    private Integer numeroApartamento;
    @Column(name = "estado", nullable = false)
    private ApartamentoEnum estadoApartamento;
    private Integer piso;
    @Column(name="valor_renta", nullable = false)
    private  double valorRenta;
    @Column(name = "descripcion", length = 500, nullable = true)
    private String descripcion;

    @OneToOne(mappedBy = "apartamento")
    private Contrato contrato;

    @ManyToOne
    @JoinColumn(name="fk_edificio", referencedColumnName = "edificio_id")
    @JsonBackReference Edificio edificio;
}
