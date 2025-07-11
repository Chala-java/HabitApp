package com.example.backend_Habit_App.domain.application.service;

import com.example.backend_Habit_App.domain.application.dto.CrearEdificioDTO;
import com.example.backend_Habit_App.domain.application.dto.EdificioDTO;

import java.util.List;
public interface EdificioService {

     EdificioDTO guardarEdificio(CrearEdificioDTO dto);
     List<EdificioDTO> listarEdificios();
     EdificioDTO buscarEdificioById(Long id) throws Exception;
    EdificioDTO eliminarEdificioById(Long id) throws Exception;
    EdificioDTO modificarEdificioById(Long id, EdificioDTO datosEdificio) throws Exception;

}
