package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.InquilinoDTO;
import com.example.backend_Habit_App.domain.application.dto.RegistroInquilinoDTO;
import com.example.backend_Habit_App.domain.model.Inquilino;

public class InquilinoMapper {

    public static Inquilino toEntity(InquilinoDTO dto){

        return new Inquilino(
                dto.getId(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getCorreo(),
                dto.getTelefono(),
                dto.getCedula(),
                null
        );
    }
    public static InquilinoDTO toDTO(Inquilino inquilino){
        return new InquilinoDTO(
                inquilino.getId(),
                inquilino.getNombre(),
                inquilino.getApellido(),
                inquilino.getCorreo(),
                inquilino.getCedula(),
                inquilino.getTelefono()
        );
    }
}
