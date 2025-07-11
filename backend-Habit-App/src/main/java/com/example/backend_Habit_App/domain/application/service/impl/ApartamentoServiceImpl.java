package com.example.backend_Habit_App.domain.application.service.impl;

import com.example.backend_Habit_App.domain.application.dto.ApartamentoDTO;
import com.example.backend_Habit_App.domain.application.dto.CrearApartamentoDTO;
import com.example.backend_Habit_App.domain.application.mapper.ApartamentoMapper;
import com.example.backend_Habit_App.domain.application.mapper.CrearApartamentoMapper;
import com.example.backend_Habit_App.domain.application.service.ApartamentoService;
import com.example.backend_Habit_App.domain.infrastructure.repository.ApartamentoRepository;
import com.example.backend_Habit_App.domain.infrastructure.repository.EdificioRepository;
import com.example.backend_Habit_App.domain.model.Apartamento;
import com.example.backend_Habit_App.domain.model.Edificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApartamentoServiceImpl implements ApartamentoService {
    @Autowired
    ApartamentoRepository apartamentoRepository;

    @Autowired
    EdificioRepository edificioRepository;
    public ApartamentoDTO guardarApartamento(CrearApartamentoDTO dto) throws Exception{
        Edificio edificio = edificioRepository.findById(dto.getIdEdificio())
                .orElseThrow(() -> new Exception("Edificio no encontrado con ID: " + dto.getIdEdificio()));
        Apartamento apartamento = CrearApartamentoMapper.toEntity(dto, edificio);
        Apartamento guardado = apartamentoRepository.save(apartamento);
        return ApartamentoMapper.toDTO(guardado);
    }

    public List<ApartamentoDTO> listarApartamento() {
            List<Apartamento> apartamentos = apartamentoRepository.findAll();
            List<ApartamentoDTO> resultado = new ArrayList<>();
            for (Apartamento p : apartamentos) {
                resultado.add(ApartamentoMapper.toDTO(p));
            }
            return resultado;
    }

    public ApartamentoDTO buscarApartamentoPorId(Long id) throws Exception{
        Optional<Apartamento> resultado = apartamentoRepository.findById(id);
        if (resultado.isPresent()){
            return ApartamentoMapper.toDTO(resultado.get());
        }else {
            throw  new Exception("No se podido Encontrar apartamento por "+id);
        }
    }


    public ApartamentoDTO modificarApartamentoPorId(Long id, Apartamento datos) throws Exception {
        Optional<Apartamento> resultado = apartamentoRepository.findById(id);
        if (resultado.isPresent()) {
            Apartamento apartamento = resultado.get();

            apartamento.setEdificio(datos.getEdificio());
            apartamento.setEstadoApartamento(datos.getEstadoApartamento());
            apartamento.setNumeroApartamento(datos.getNumeroApartamento());
            apartamento.setPiso(datos.getPiso());
            apartamento.setDescripcion(datos.getDescripcion());
            apartamento.setValorRenta(datos.getValorRenta());
            apartamento.setContrato(datos.getContrato());
            Apartamento actualizado = apartamentoRepository.save(apartamento);
            return ApartamentoMapper.toDTO(actualizado);
        } else {
            throw new Exception("No se a Encontrado Apartamento por " + id);
        }
    }


    public ApartamentoDTO eliminarApartamentoPorId(Long id) throws Exception {
        Optional<Apartamento> resultado = apartamentoRepository.findById(id);
        if (resultado.isPresent()) {
            Apartamento apartamento = resultado.get();
            apartamentoRepository.delete(apartamento);
            return ApartamentoMapper.toDTO(apartamento);
        } else {
            throw new Exception("No se a Encontrado Apartamento por " + id);
        }
    }


}
