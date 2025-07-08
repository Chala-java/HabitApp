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
    @Column(name = "contrato_id")
    protected  Long id;
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "valor_renta", nullable = false)
    private double valorRenta;
    @Column(name = "frecuencia_pago", nullable = false)
    private String frecuenciaPago;
    @Column(name = "deposito", nullable = false)
    private double deposito;


//    Relaciones
    @OneToOne
    @JoinColumn(name = "id_inquilino", referencedColumnName = "id")
    private Inquilino inquilino;

    @OneToOne
    @JoinColumn(name = "id_propietario", referencedColumnName = "id")
    private Propietario propietario;

    @OneToOne
    @JoinColumn(name = "id_apartamento", referencedColumnName = "apartamento_id")
    private Apartamento apartamento;

    @OneToMany(mappedBy = "contrato")
    @JsonManagedReference
    private List<Pago> pagos;


    public Contrato() {
    }

    public Contrato(Long id, LocalDate fechaInicio, LocalDate fechaFin, String estado, double valorRenta, String frecuenciaPago, double deposito, Inquilino inquilino, Propietario propietario, Apartamento apartamento, List<Pago> pagos) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.valorRenta = valorRenta;
        this.frecuenciaPago = frecuenciaPago;
        this.deposito = deposito;
        this.inquilino = inquilino;
        this.propietario = propietario;
        this.apartamento = apartamento;
        this.pagos = pagos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getValorRenta() {
        return valorRenta;
    }

    public void setValorRenta(double valorRenta) {
        this.valorRenta = valorRenta;
    }

    public String getFrecuenciaPago() {
        return frecuenciaPago;
    }

    public void setFrecuenciaPago(String frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
}
