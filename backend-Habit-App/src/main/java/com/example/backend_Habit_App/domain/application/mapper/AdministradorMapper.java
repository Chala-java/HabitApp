package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.AdministradorDTO;
import com.example.backend_Habit_App.domain.application.dto.PropietarioDTO;
import com.example.backend_Habit_App.domain.model.Administrador;
import com.example.backend_Habit_App.domain.model.RolEnum;

public class AdministradorMapper {

    public static Administrador toEntity(AdministradorDTO dto){

        return new Administrador(
                dto.getId(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getCorreo(),
                dto.getTelefono(),
                dto.getCedula(),
                RolEnum.ADMINISTRADOR,
                null

        );

    }

    public static AdministradorDTO toDTO (Administrador administrador){
        return new AdministradorDTO(
                administrador.getId(),
                administrador.getNombre(),
                administrador.getApellido(),
                administrador.getCorreo(),
                administrador.getTelefono(),
                administrador.getCedula(),
                administrador.getRol()
        );
    }
}
