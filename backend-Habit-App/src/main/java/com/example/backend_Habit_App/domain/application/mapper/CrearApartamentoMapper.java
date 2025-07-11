package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.ApartamentoDTO;
import com.example.backend_Habit_App.domain.application.dto.CrearApartamentoDTO;
import com.example.backend_Habit_App.domain.model.Apartamento;
import com.example.backend_Habit_App.domain.model.Edificio;

public class CrearApartamentoMapper {

    public static Apartamento toEntity(CrearApartamentoDTO apartamentoDTO, Edificio edificio){
        return new Apartamento(
                null,
                apartamentoDTO.getNumeroApartamento(),
                apartamentoDTO.getEstadoApartamento(),
                apartamentoDTO.getPiso(),
                apartamentoDTO.getValorRenta(),
                apartamentoDTO.getDescripcion(),
                null,
                edificio
        );
    }
}
