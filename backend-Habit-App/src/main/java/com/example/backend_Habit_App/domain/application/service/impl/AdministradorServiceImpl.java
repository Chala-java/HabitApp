package com.example.backend_Habit_App.domain.application.service.impl;

import com.example.backend_Habit_App.domain.application.dto.*;
import com.example.backend_Habit_App.domain.application.mapper.AdministradorMapper;
import com.example.backend_Habit_App.domain.application.mapper.RegistroAdminMapper;
import com.example.backend_Habit_App.domain.application.service.AdministradorService;
import com.example.backend_Habit_App.domain.infrastructure.repository.AdministradorRepository;
import com.example.backend_Habit_App.domain.model.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServiceImpl implements AdministradorService {
    @Autowired
    AdministradorRepository repository;
    public AdministradorDTO guardarAdministrador(RegistroAdminDTO dto) throws Exception{
        try {
            Administrador entidad = RegistroAdminMapper.toEntity(dto);
            Administrador guardado = repository.save(entidad);
            return AdministradorMapper.toDTO(guardado);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<AdministradorDTO> listarAdministrador(){
            List<Administrador> administradores = repository.findAll();
            List<AdministradorDTO> resultado = new ArrayList<>();
            for (Administrador a: administradores){
                resultado.add(AdministradorMapper.toDTO(a));
            }
            return resultado;
        }

        public AdministradorDTO buscarAdminPorId(Long id) throws Exception{
            Optional<Administrador> resultado = repository.findById(id);
            if (resultado.isPresent()){
                return AdministradorMapper.toDTO(resultado.get());
            }else {
                throw new Exception("Administrador no encontrado con ID: " + id);

            }
        }

        public AdministradorDTO modificarAdminPorId(Long id, AdministradorDTO datosAdmin) throws Exception {
            Optional<Administrador> resultado = repository.findById(id);
            if (resultado.isPresent()) {
                Administrador administrador = resultado.get();
                administrador.setNombre(datosAdmin.getNombre());
                administrador.setApellido(datosAdmin.getApellido());
                administrador.setCedula(datosAdmin.getCedula());
                administrador.setCorreo(datosAdmin.getCorreo());
                Administrador actualizado = repository.save(administrador);
                return AdministradorMapper.toDTO(actualizado);
            } else {
                throw new Exception("No se encontró ningún propietario con ID: " + id);

            }
        }

        public AdministradorDTO eliminarAdministrador(Long id)throws Exception{
            Optional<Administrador> resultado = repository.findById(id);
            if (resultado.isPresent()){
                Administrador eliminado = resultado.get();
                repository.delete(eliminado);
                return AdministradorMapper.toDTO(eliminado);
            }else {
                throw new Exception("No se encontró ningún Administrador con ID: " + id);
            }
        }


    public AdministradorDTO iniciarSesion(IniciarSesionAdminDTO dto) throws Exception {
        Optional<Administrador> resultado = repository.findByCorreo(dto.getCorreo());

        if (resultado.isPresent()) {
            Administrador admin = resultado.get();
            if (admin.getContrasena().equals(dto.getContrasena())) {
                return AdministradorMapper.toDTO(admin);
            } else {
                throw new Exception("Contraseña incorrecta");
            }
        } else {
            throw new Exception("Administrador no encontrado con el correo: " + dto.getCorreo());
        }
    }


    }

