package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.CrearEdificioDTO;
import com.example.backend_Habit_App.domain.model.Edificio;

public class CrearEdificioMapper {

    public static Edificio toEntity(CrearEdificioDTO dto) {
        return new Edificio(
                null,// El id se genera automáticamente
                dto.getNombre(),
                dto.getDireccion(),
                dto.getValorAdministracion(),
                dto.getNumeroApartamento(),
                dto.getPisos(),
                null
        );
    }
}
