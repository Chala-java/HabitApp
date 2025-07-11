package com.example.backend_Habit_App.domain.application.service;

import com.example.backend_Habit_App.domain.application.dto.ApartamentoDTO;
import com.example.backend_Habit_App.domain.application.dto.CrearApartamentoDTO;
import com.example.backend_Habit_App.domain.model.Apartamento;
import java.util.List;

public interface ApartamentoService {
    ApartamentoDTO guardarApartamento(CrearApartamentoDTO dto) throws Exception;
    List<ApartamentoDTO> listarApartamento();
    ApartamentoDTO buscarApartamentoPorId(Long id) throws Exception;
    ApartamentoDTO modificarApartamentoPorId(Long id, Apartamento datos) throws Exception;
    ApartamentoDTO eliminarApartamentoPorId(Long id) throws Exception;











}
