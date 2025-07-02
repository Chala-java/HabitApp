package com.example.backend_Habit_App.domain.application.service;
import com.example.backend_Habit_App.domain.application.dto.*;
import java.util.List;

public interface AdministradorService {
    AdministradorDTO guardarAdministrador(RegistroAdminDTO dto) throws Exception;
    List<AdministradorDTO> listarAdministrador();
    AdministradorDTO buscarAdminPorId(Long id) throws Exception;

   AdministradorDTO modificarAdminPorId(Long id, AdministradorDTO datosAdmin) throws Exception;

   AdministradorDTO eliminarAdministrador(Long id)throws Exception;

  AdministradorDTO iniciarSesion(IniciarSesionAdminDTO dto) throws Exception;




}
