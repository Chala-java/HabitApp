package com.example.backend_Habit_App.domain.application.service.impl;

import com.example.backend_Habit_App.domain.application.dto.ContratoDTO;
import com.example.backend_Habit_App.domain.application.dto.CrearContratoDTO;
import com.example.backend_Habit_App.domain.application.mapper.CrearContratoMapper;
import com.example.backend_Habit_App.domain.application.service.ContratoService;
import com.example.backend_Habit_App.domain.infrastructure.repository.ApartamentoRepository;
import com.example.backend_Habit_App.domain.infrastructure.repository.ContratoRepository;
import com.example.backend_Habit_App.domain.infrastructure.repository.InquilinoRepository;
import com.example.backend_Habit_App.domain.infrastructure.repository.PropietarioRepository;
import com.example.backend_Habit_App.domain.model.Apartamento;
import com.example.backend_Habit_App.domain.model.Contrato;
import com.example.backend_Habit_App.domain.model.Inquilino;
import com.example.backend_Habit_App.domain.model.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContratoServiceImpl implements ContratoService {
    @Autowired
    PropietarioRepository propietarioRepository;
    @Autowired
    InquilinoRepository inquilinoRepository;
    @Autowired
    ContratoRepository contratoRepository;

    @Autowired
    ApartamentoRepository apartamentoRepository;

    public ContratoDTO crearContrato(CrearContratoDTO dto) throws Exception {
        Propietario propietario = propietarioRepository.findById(dto.getIdPropietario())
                .orElseThrow(() -> new Exception("propietario no encontrado"));
        Inquilino inquilino = inquilinoRepository.findById(dto.getIdInquilino())
                .orElseThrow(() -> new Exception("Inquilino no encontrado"));

        Apartamento apartamento = apartamentoRepository.findById(dto.getIdApartamento())
                .orElseThrow(() -> new Exception("Apartamento no encontrado"));

        Contrato contrato = CrearContratoMapper.toEntity(dto, inquilino, propietario);
        Contrato guardado = contratoRepository.save(contrato);

        return CrearContratoMapper.toDTO(guardado);
    }

    public List<ContratoDTO> listarContratos() {
        List<Contrato> contrato = contratoRepository.findAll();
        List<ContratoDTO> resultado = new ArrayList<>();
        for (Contrato p : contrato) {
            resultado.add(CrearContratoMapper.toDTO(p));
        }
        return resultado;
    }


    public ContratoDTO buscarContratoPorId(Long id) throws Exception {
        Optional<Contrato> resultado = contratoRepository.findById(id);
        if (resultado.isPresent()) {
            return CrearContratoMapper.toDTO(resultado.get());
        } else {
            throw new Exception("Propietario no Encontrador Por id");
        }
    }

    public ContratoDTO modificarContratoPorId(Long id, ContratoDTO datosContrato) throws Exception {
        Optional<Contrato> resultado = contratoRepository.findById(id);
        if (resultado.isEmpty()) {
            throw new Exception("Contrato no encontrado por id: " + id);
        }

        Contrato contrato = resultado.get();

        // Actualizamos los campos simples
        contrato.setFechaInicio(datosContrato.getFechaInicio());
        contrato.setFechaFin(datosContrato.getFechaFin());
        contrato.setEstado(datosContrato.getEstado());
        contrato.setValorRenta(datosContrato.getValorRenta());
        contrato.setFrecuenciaPago(datosContrato.getFrecuenciaPago());
        contrato.setDeposito(datosContrato.getDeposito());

        // Actualizar propietario (si cambia)
        Propietario propietario = propietarioRepository.findById(datosContrato.getIdPropietario())
                .orElseThrow(() -> new Exception("Propietario no encontrado"));
        contrato.setPropietario(propietario);

        // Actualizar inquilino (si cambia)
        Inquilino inquilino = inquilinoRepository.findById(datosContrato.getIdInquilino())
                .orElseThrow(() -> new Exception("Inquilino no encontrado"));
        contrato.setInquilino(inquilino);

        // Guardar cambios en la base de datos
        Contrato actualizado = contratoRepository.save(contrato);

        return CrearContratoMapper.toDTO(actualizado);
    }



    public ContratoDTO eliminarContratoPorId(Long id) throws Exception {
        Optional<Contrato> resultado = contratoRepository.findById(id);
        if (resultado.isPresent()) {
            Contrato eliminado = resultado.get();
            contratoRepository.delete(eliminado);
            return CrearContratoMapper.toDTO(eliminado);
        }else {
            throw new Exception("Propietario no encontrado por " + id);
        }

    }




































}