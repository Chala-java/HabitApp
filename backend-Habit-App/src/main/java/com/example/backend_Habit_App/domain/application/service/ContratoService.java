package com.example.backend_Habit_App.domain.application.service;
import com.example.backend_Habit_App.domain.application.dto.ContratoDTO;
import com.example.backend_Habit_App.domain.application.dto.CrearContratoDTO;
import java.util.List;
public interface ContratoService {
    ContratoDTO crearContrato(CrearContratoDTO dto) throws Exception;
    List<ContratoDTO> listarContratos();
    ContratoDTO buscarContratoPorId(Long id) throws Exception;
    ContratoDTO modificarContratoPorId(Long id, ContratoDTO datosContrato) throws Exception;
    ContratoDTO eliminarContratoPorId(Long id) throws Exception;

}
