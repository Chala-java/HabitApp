package com.example.backend_Habit_App.domain.application.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class CrearContratoDTO {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private double valorRenta;
    private String frecuenciaPago;
    private double deposito;

    //Propietario
    protected  Long idPropietario;

    //Inquilino
    protected  Long idInquilino;

    //Apartamento

    protected Long idApartamento;


    public CrearContratoDTO() {
    }

    public CrearContratoDTO(LocalDate fechaInicio, LocalDate fechaFin, String estado, double valorRenta, String frecuenciaPago, double deposito, Long idPropietario, Long idInquilino, Long idApartamento) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.valorRenta = valorRenta;
        this.frecuenciaPago = frecuenciaPago;
        this.deposito = deposito;
        this.idPropietario = idPropietario;
        this.idInquilino = idInquilino;
        this.idApartamento = idApartamento;
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

    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Long getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(Long idInquilino) {
        this.idInquilino = idInquilino;
    }

    public Long getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(Long idApartamento) {
        this.idApartamento = idApartamento;
    }
}
