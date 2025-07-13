package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.IniciarSesionAdminDTO;
import com.example.backend_Habit_App.domain.model.Administrador;
import com.example.backend_Habit_App.domain.model.RolEnum;

public class IniciarSesionAdminMapper {

    public static IniciarSesionAdminDTO toEntity(IniciarSesionAdminDTO iniciarSesionAdminDTO){
        return new IniciarSesionAdminDTO(
                iniciarSesionAdminDTO.getCorreo(),
                iniciarSesionAdminDTO.getContrasena(),
                RolEnum.ADMINISTRADOR
        );
    }
}
