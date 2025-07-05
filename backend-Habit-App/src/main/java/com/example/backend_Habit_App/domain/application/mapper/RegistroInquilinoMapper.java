package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.RegistroInquilinoDTO;
import com.example.backend_Habit_App.domain.model.Inquilino;

public class RegistroInquilinoMapper {

    public static Inquilino toEntity(RegistroInquilinoDTO dto){

        return new Inquilino(
                null,
                dto.getNombre(),
                dto.getApellido(),
                dto.getCorreo(),
                dto.getTelefono(),
                dto.getCedula(),
                dto.getContrasena()
        );
    }
}
