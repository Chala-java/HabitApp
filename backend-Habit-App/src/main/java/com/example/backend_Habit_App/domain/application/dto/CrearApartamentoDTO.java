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


}
