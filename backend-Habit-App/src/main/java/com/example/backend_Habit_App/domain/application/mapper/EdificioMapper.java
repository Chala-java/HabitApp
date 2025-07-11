package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.EdificioDTO;
import com.example.backend_Habit_App.domain.model.Edificio;

public class EdificioMapper {

    public static Edificio toEntity(EdificioDTO dto) {
        return new Edificio(
                dto.getId(),
                dto.getNombre(),
                dto.getDireccion(),
                dto.getValorAdministracion(),
                dto.getNumeroApartamento(),
                dto.getPisos(),
                null
        );
    }

    public static EdificioDTO toDTO(Edificio edificio) {
        return new EdificioDTO(
                edificio.getId(),
                edificio.getNombre(),
                edificio.getDireccion(),
                edificio.getValorAdministracion(),
                edificio.getNumeroApartamento(),
                edificio.getPisos()
        );
    }
}
