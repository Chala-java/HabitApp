package com.example.backend_Habit_App.domain.application.mapper;

import com.example.backend_Habit_App.domain.application.dto.ContratoDTO;
import com.example.backend_Habit_App.domain.application.dto.CrearContratoDTO;

import com.example.backend_Habit_App.domain.model.Apartamento;
import com.example.backend_Habit_App.domain.model.Contrato;
import com.example.backend_Habit_App.domain.model.Inquilino;
import com.example.backend_Habit_App.domain.model.Propietario;

public class CrearContratoMapper {
    public static Contrato toEntity(CrearContratoDTO dto, Inquilino inquilino, Propietario propietario){
     Contrato contrato = new Contrato();
        contrato.setFechaInicio(dto.getFechaInicio());
        contrato.setFechaFin(dto.getFechaFin());
        contrato.setEstado(dto.getEstado());
        contrato.setValorRenta(dto.getValorRenta());
        contrato.setFrecuenciaPago(dto.getFrecuenciaPago());
        contrato.setDeposito(dto.getDeposito());
        contrato.setInquilino(inquilino);
        contrato.setPropietario(propietario);


        return contrato;
    }
    public static ContratoDTO toDTO(Contrato contrato) {
        ContratoDTO dto = new ContratoDTO();
        dto.setFechaInicio(contrato.getFechaInicio());
        dto.setFechaFin(contrato.getFechaFin());
        dto.setEstado(contrato.getEstado());
        dto.setValorRenta(contrato.getValorRenta());
        dto.setFrecuenciaPago(contrato.getFrecuenciaPago());
        dto.setDeposito(contrato.getDeposito());

        // Propietario
        Propietario propietario = contrato.getPropietario();
        dto.setIdPropietario(propietario.getId());
        dto.setNombrePropietario(propietario.getNombre());
        dto.setApellidoPropietario(propietario.getApellido());
        dto.setCedulaPropietario(propietario.getCedula());
        dto.setCorreoPropietario(propietario.getCorreo());
        dto.setTelefonoPropietario(propietario.getTelefono());
        dto.setNumeroCuentaPropietario(propietario.getNumero_cuenta());
        dto.setMetodoPagoPropietario(propietario.getMetodo_pago());

        // Inquilino
        Inquilino inquilino = contrato.getInquilino();
        dto.setIdInquilino(inquilino.getId());
        dto.setNombreInquilino(inquilino.getNombre());
        dto.setApellidoInquilino(inquilino.getApellido());
        dto.setCedulaInquilino(inquilino.getCedula());
        dto.setCorreoInquilino(inquilino.getCorreo());
        dto.setTelefonoInquilino(inquilino.getTelefono());

        //Apartamento

        Apartamento apartamento = contrato.getApartamento();
        dto.setNumeroApartamento(apartamento.getNumeroApartamento());
        dto.setEstadoApartamento(apartamento.getEstadoApartamento());
        dto.setPiso(apartamento.getPiso());
        dto.setValorDeRenta(apartamento.getValorRenta());
        dto.setDescripcion(apartamento.getDescripcion());

        return dto;
    }

}
