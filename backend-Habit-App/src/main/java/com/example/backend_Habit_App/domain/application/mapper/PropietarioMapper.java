package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.PropietarioDTO;
import com.example.backend_Habit_App.domain.model.Propietario;
import com.example.backend_Habit_App.domain.model.RolEnum;

public class PropietarioMapper {
    public static Propietario toEntity(PropietarioDTO dto){

        return new Propietario(
                dto.getId(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getCorreo(),
                dto.getTelefono(),
                dto.getCedula(),
                RolEnum.PROPIETARIO,
                null,
                dto.getNumero_cuenta(),
                dto.getMetodo_pago(),
                null
        );

    }
    public static PropietarioDTO toDTO (Propietario propietario){

        return  new PropietarioDTO(
                propietario.getId(),
                propietario.getNombre(),
                propietario.getApellido(),
                propietario.getCorreo(),
                propietario.getTelefono(),
                propietario.getCedula(),
                propietario.getRol(),
                propietario.getNumero_cuenta(),
                propietario.getMetodo_pago()
                );
    }
}
