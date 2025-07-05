package com.example.backend_Habit_App.domain.application.service;

import com.example.backend_Habit_App.domain.application.dto.IniciarSesionDTO;
import com.example.backend_Habit_App.domain.application.dto.PropietarioDTO;
import com.example.backend_Habit_App.domain.application.dto.RegistroPropietarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PropietarioService {

    PropietarioDTO guardarPropietario(RegistroPropietarioDTO dto) throws Exception;
    List <PropietarioDTO> listarPropietarios();
    PropietarioDTO buscarPropietarioPorID(Long id) throws Exception;

    PropietarioDTO eliminarPropietarioPorID(Long id) throws Exception;

    PropietarioDTO modificarPropietarioPorID(Long id, PropietarioDTO datosPropietario) throws Exception;

    PropietarioDTO iniciarSesion(IniciarSesionDTO dto) throws Exception;
}
