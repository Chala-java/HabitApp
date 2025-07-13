package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.RegistroPropietarioDTO;
import com.example.backend_Habit_App.domain.model.Propietario;
import com.example.backend_Habit_App.domain.model.RolEnum;

public class RegistroPropietarioMapper {

    public static Propietario toEntity(RegistroPropietarioDTO dto){

        return new Propietario(
                null,
                dto.getCorreo(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getTelefono(),
                dto.getCedula(),
                RolEnum.PROPIETARIO,
                dto.getContrasena(),
                dto.getNumero_cuenta(),
                dto.getMetodo_pago(),
                null
        );
    }
}
