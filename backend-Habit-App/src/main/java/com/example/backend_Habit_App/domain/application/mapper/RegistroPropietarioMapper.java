package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.RegistroPropietarioDTO;
import com.example.backend_Habit_App.domain.model.Propietario;

public class RegistroPropietarioMapper {

    public static Propietario toEntity(RegistroPropietarioDTO dto){

        return new Propietario(
                null,
                dto.getCorreo(),
                dto.getTelefono(),
                dto.getCedula(),
                dto.getContrasena(),
                dto.getNumero_cuenta(),
                dto.getMetodo_pago()
        );
    }
}
