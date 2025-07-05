package com.example.backend_Habit_App.domain.application.service.impl;
import com.example.backend_Habit_App.domain.application.dto.*;
import com.example.backend_Habit_App.domain.application.mapper.InquilinoMapper;
import com.example.backend_Habit_App.domain.application.mapper.PropietarioMapper;
import com.example.backend_Habit_App.domain.application.mapper.RegistroInquilinoMapper;
import com.example.backend_Habit_App.domain.application.service.InquilinoService;
import com.example.backend_Habit_App.domain.infrastructure.repository.InquilinoRepository;
import com.example.backend_Habit_App.domain.model.Inquilino;
import com.example.backend_Habit_App.domain.model.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InquilinoServiceImpl implements InquilinoService {

    @Autowired
    InquilinoRepository repository;

    public InquilinoDTO guardarInquilino(RegistroInquilinoDTO dto){
        try {
            Inquilino entidad= RegistroInquilinoMapper.toEntity(dto);
            Inquilino guardado=repository.save(entidad);
            return InquilinoMapper.toDTO(guardado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<InquilinoDTO> listarInquilino(){
        List<Inquilino> inquilinos = repository.findAll();
        List<InquilinoDTO> resultado = new ArrayList<>();
        for (Inquilino i: inquilinos ){
            resultado.add(InquilinoMapper.toDTO(i));
        }
        return resultado;
    }
    public InquilinoDTO buscarInquilinoById(Long id) throws Exception{
        Optional<Inquilino> resultado=repository.findById(id);
        if(resultado.isPresent()) {
            return InquilinoMapper.toDTO(resultado.get());
        }else {
            throw new Exception("Propietario no encontrado con ID: " + id);
        }
    }
    public InquilinoDTO eliminarInquilinoById(Long id) throws Exception{
        Optional<Inquilino> resultado=repository.findById(id);
        if(resultado.isPresent()){
            Inquilino eliminado = resultado.get();
            repository.delete(eliminado);
            return InquilinoMapper.toDTO(eliminado);
        }else{
            throw new Exception("No se encontró ningún propietario con ID: " + id);
        }
    }

    public InquilinoDTO modificarInquilinoById(Long id, InquilinoDTO datosInquilino)throws Exception{
        Optional<Inquilino> resultado=repository.findById(id);
        if(resultado.isPresent()){
          Inquilino inquilino=resultado.get();
          inquilino.setNombre(datosInquilino.getNombre());
          inquilino.setApellido(datosInquilino.getApellido());
          inquilino.setCorreo(datosInquilino.getCorreo());
          inquilino.setCedula(datosInquilino.getCedula());
          inquilino.setTelefono(datosInquilino.getTelefono());
          Inquilino actualizado=repository.save(inquilino);
          return InquilinoMapper.toDTO(actualizado);
        }else{
            throw new Exception("No se encontró ningún propietario con ID: " + id);
        }
    }


    public InquilinoDTO iniciarSesion(IniciarSesionDTO iniciarSesionDTO) throws Exception {
        Optional<Inquilino>resultado = repository.findByCorreo(iniciarSesionDTO.getCorreo());

        if (resultado.isPresent()) {
            Inquilino inquilino = resultado.get();
            if (inquilino.getContrasena().equals(iniciarSesionDTO.getContrasena())) {
                return InquilinoMapper.toDTO(inquilino);
            } else {
                throw new Exception("Contraseña Incorrecta");
            }
        } else {
            throw new Exception("Usuario no encontrado con correo"+iniciarSesionDTO.getCorreo());
        }
    }
    }

