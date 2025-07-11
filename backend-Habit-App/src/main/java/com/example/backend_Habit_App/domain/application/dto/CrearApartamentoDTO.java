package com.example.backend_Habit_App.domain.application.dto;

import com.example.backend_Habit_App.domain.model.ApartamentoEnum;

public class CrearApartamentoDTO {
    private Integer numeroApartamento;
    private ApartamentoEnum estadoApartamento;
    private Integer piso;
    private  double valorRenta;
    private String descripcion;

    protected Long idEdificio;

    public CrearApartamentoDTO() {
    }

    public CrearApartamentoDTO(Integer numeroApartamento, ApartamentoEnum estadoApartamento, Integer piso, double valorRenta, String descripcion, Long idEdificio) {
        this.numeroApartamento = numeroApartamento;
        this.estadoApartamento = estadoApartamento;
        this.piso = piso;
        this.valorRenta = valorRenta;
        this.descripcion = descripcion;
        this.idEdificio = idEdificio;
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

    public Long getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(Long idEdificio) {
        this.idEdificio = idEdificio;
    }
}
