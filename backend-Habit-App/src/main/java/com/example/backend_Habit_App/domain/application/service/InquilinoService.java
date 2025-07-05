package com.example.backend_Habit_App.domain.application.service;

import com.example.backend_Habit_App.domain.application.dto.IniciarSesionDTO;
import com.example.backend_Habit_App.domain.application.dto.InquilinoDTO;
import com.example.backend_Habit_App.domain.application.dto.RegistroInquilinoDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InquilinoService {

    InquilinoDTO guardarInquilino(RegistroInquilinoDTO dto) throws Exception;
    List<InquilinoDTO> listarInquilino();
    InquilinoDTO buscarInquilinoById(Long id) throws Exception;
    InquilinoDTO eliminarInquilinoById(Long id) throws Exception;
    InquilinoDTO modificarInquilinoById(Long id, InquilinoDTO datosInquilino)throws Exception;
    InquilinoDTO iniciarSesion(IniciarSesionDTO iniciarSesionDTO) throws Exception;

}
