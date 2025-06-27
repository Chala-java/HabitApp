package com.example.backend_Habit_App.domain.application.service.impl;

import com.example.backend_Habit_App.domain.application.dto.IniciarSesionDTO;
import com.example.backend_Habit_App.domain.application.dto.PropietarioDTO;
import com.example.backend_Habit_App.domain.application.dto.RegistroPropietarioDTO;
import com.example.backend_Habit_App.domain.application.mapper.PropietarioMapper;
import com.example.backend_Habit_App.domain.application.mapper.RegistroPropietarioMapper;
import com.example.backend_Habit_App.domain.application.service.PropietarioService;
import com.example.backend_Habit_App.domain.infrastructure.repository.PropietarioRepository;
import com.example.backend_Habit_App.domain.model.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropietarioServiceImpl  implements PropietarioService{
    @Autowired
    private PropietarioRepository repository;

    @Override
    public  PropietarioDTO guardarPropietario(RegistroPropietarioDTO dto) throws Exception{
        try {
            Propietario entidad = RegistroPropietarioMapper.toEntity(dto);
            Propietario guardado = repository.save(entidad);
            return PropietarioMapper.toDTO(guardado);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<PropietarioDTO> listarPropietarios() {
            List<Propietario> propietarios = repository.findAll();
            List<PropietarioDTO> resultado = new ArrayList<>();
            for (Propietario p: propietarios ){
                resultado.add(PropietarioMapper.toDTO(p));
            }
            return resultado;
    }

    public PropietarioDTO buscarPropietarioPorID(Long id) throws Exception {
        Optional<Propietario> resultado = repository.findById(id);
        if (resultado.isPresent()) {
            return PropietarioMapper.toDTO(resultado.get());
        } else {
            throw new Exception("Propietario no encontrado con ID: " + id);
        }
    }

    public PropietarioDTO eliminarPropietarioPorID(Long id) throws Exception{
        Optional<Propietario> resultado = repository.findById(id);
        if (resultado.isPresent()){
            Propietario eliminado = resultado.get();
            repository.delete(eliminado);
            return PropietarioMapper.toDTO(eliminado);
        }else {
            throw new Exception("No se encontró ningún propietario con ID: " + id);
        }
    }

    public PropietarioDTO modificarPropietarioPorID(Long id , PropietarioDTO datosPropietario) throws Exception {
        Optional<Propietario> resultado = repository.findById(id);
        if (resultado.isPresent()) {

            Propietario propietario = resultado.get();
            propietario.setMetodo_pago(datosPropietario.getMetodo_pago());
            propietario.setCedula(datosPropietario.getCedula());
            propietario.setNumero_cuenta(datosPropietario.getNumero_cuenta());
            propietario.setCorreo(datosPropietario.getCorreo());
            propietario.setTelefono(datosPropietario.getTelefono());
            Propietario actualizado = repository.save(propietario);
            return PropietarioMapper.toDTO(actualizado);
        } else {
            throw new Exception("No se encontró ningún propietario con ID: " + id);
        }
    }



    //Iniciar Sesion Propietario
    public PropietarioDTO iniciarSesion(IniciarSesionDTO iniciarSesionDTO) throws Exception {
        Optional<Propietario> resultado = repository.findByCorreo(iniciarSesionDTO.getCorreo());

        if (resultado.isPresent()) {
            Propietario propietario = resultado.get();
            if (propietario.getContrasena().equals(iniciarSesionDTO.getContrasena())) {
            return PropietarioMapper.toDTO(propietario);
        } else {
            throw new Exception("Contraseña Incorrecta");
        }
    } else {
            throw new Exception("Usuario no encontrado con correo"+iniciarSesionDTO.getCorreo());
        }
    }






}
