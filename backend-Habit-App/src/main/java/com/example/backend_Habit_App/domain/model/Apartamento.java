package com.example.backend_Habit_App.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "apartamento")
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartamento_id")
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

    public Apartamento() {
    }

    public Apartamento(Long id, Integer numeroApartamento, ApartamentoEnum estadoApartamento, Integer piso, double valorRenta, String descripcion, Contrato contrato, Edificio edificio) {
        this.id = id;
        this.numeroApartamento = numeroApartamento;
        this.estadoApartamento = estadoApartamento;
        this.piso = piso;
        this.valorRenta = valorRenta;
        this.descripcion = descripcion;
        this.contrato = contrato;
        this.edificio = edificio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(Integer numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public ApartamentoEnum getEstadoApartamento() {
        return estadoApartamento;
    }

    public void setEstadoApartamento(ApartamentoEnum estadoApartamento) {
        this.estadoApartamento = estadoApartamento;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public double getValorRenta() {
        return valorRenta;
    }

    public void setValorRenta(double valorRenta) {
        this.valorRenta = valorRenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
}
