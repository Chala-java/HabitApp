package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.ApartamentoDTO;
import com.example.backend_Habit_App.domain.model.Apartamento;
import com.example.backend_Habit_App.domain.model.Edificio;

public class ApartamentoMapper {

    public static Apartamento toEntity(ApartamentoDTO apartamentoDTO, Edificio edificio){
        return new Apartamento(
                apartamentoDTO.getId(),
                apartamentoDTO.getNumeroApartamento(),
                apartamentoDTO.getEstadoApartamento(),
                apartamentoDTO.getPiso(),
                apartamentoDTO.getValorRenta(),
                apartamentoDTO.getDescripcion(),
                null,
                edificio
        );
    }

    public static ApartamentoDTO toDTO(Apartamento apartamento){
      return new ApartamentoDTO(
              apartamento.getId(),
              apartamento.getNumeroApartamento(),
              apartamento.getEstadoApartamento(),
              apartamento.getPiso(),
              apartamento.getValorRenta(),
              apartamento.getDescripcion(),
              apartamento.getEdificio().getId()
      );
    }
}
