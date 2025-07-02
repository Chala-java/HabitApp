package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.RegistroAdminDTO;
import com.example.backend_Habit_App.domain.model.Administrador;

public class RegistroAdminMapper {

    public static Administrador toEntity(RegistroAdminDTO registroAdminDTO){
        return new Administrador(
                null,
                registroAdminDTO.getNombre(),
                registroAdminDTO.getApellido(),
                registroAdminDTO.getCorreo(),
                registroAdminDTO.getTelefono(),
                registroAdminDTO.getCedula(),
                registroAdminDTO.getContrasena()
        );
    }
}
