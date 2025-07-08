package com.example.backend_Habit_App.domain.application.service.impl;

import com.example.backend_Habit_App.domain.application.dto.CrearEdificioDTO;
import com.example.backend_Habit_App.domain.application.dto.EdificioDTO;
import com.example.backend_Habit_App.domain.application.mapper.CrearEdificioMapper;
import com.example.backend_Habit_App.domain.application.mapper.EdificioMapper;
import com.example.backend_Habit_App.domain.application.service.EdificioService;
import com.example.backend_Habit_App.domain.infrastructure.repository.EdificioRepository;
import com.example.backend_Habit_App.domain.model.Edificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EdificioServiceImpl implements EdificioService {
    @Autowired
    private EdificioRepository repository;

    // Crear edificio
    public EdificioDTO guardarEdificio(CrearEdificioDTO dto) {
        try {
            Edificio entidad = CrearEdificioMapper.toEntity(dto);
            Edificio guardado = repository.save(entidad);
            return EdificioMapper.toDTO(guardado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Listar edificios
    public List<EdificioDTO> listarEdificios() {
        List<Edificio> edificios = repository.findAll();
        List<EdificioDTO> resultado = new ArrayList<>();
        for (Edificio e : edificios) {
            resultado.add(EdificioMapper.toDTO(e));
        }
        return resultado;
    }

    // Buscar edificio por ID
    public EdificioDTO buscarEdificioById(Long id) throws Exception {
        Optional<Edificio> resultado = repository.findById(id);
        if (resultado.isPresent()) {
            return EdificioMapper.toDTO(resultado.get());
        } else {
            throw new Exception("Edificio no encontrado con ID: " + id);
        }
    }

    // Eliminar edificio por ID
    public EdificioDTO eliminarEdificioById(Long id) throws Exception {
        Optional<Edificio> resultado = repository.findById(id);
        if (resultado.isPresent()) {
            Edificio eliminado = resultado.get();
            repository.delete(eliminado);
            return EdificioMapper.toDTO(eliminado);
        } else {
            throw new Exception("No se encontró ningún edificio con ID: " + id);
        }
    }

    // Modificar edificio
    public EdificioDTO modificarEdificioById(Long id, EdificioDTO datosEdificio) throws Exception {
        Optional<Edificio> resultado = repository.findById(id);
        if (resultado.isPresent()) {
            Edificio edificio = resultado.get();
            edificio.setNombre(datosEdificio.getNombre());
            edificio.setDireccion(datosEdificio.getDireccion());
            edificio.setValorAdministracion(datosEdificio.getValorAdministracion());
            edificio.setNumeroApartamento(datosEdificio.getNumeroApartamento());
            edificio.setPisos(datosEdificio.getPisos());

            Edificio actualizado = repository.save(edificio);
            return EdificioMapper.toDTO(actualizado);
        } else {
            throw new Exception("No se encontró ningún edificio con ID: " + id);
        }
    }
}
