package com.example.backend_Habit_App.domain.presentation.Controller;

import com.example.backend_Habit_App.domain.application.dto.AdministradorDTO;
import com.example.backend_Habit_App.domain.application.dto.IniciarSesionAdminDTO;
import com.example.backend_Habit_App.domain.application.dto.RegistroAdminDTO;
import com.example.backend_Habit_App.domain.application.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {

    @Autowired
    AdministradorService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RegistroAdminDTO requestData) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.service.guardarAdministrador(requestData));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarAdministradores() throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.service.listarAdministrador());
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAdministradorPorId(@PathVariable Long id)throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.service.buscarAdminPorId(id));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarAdministradorPorId(@PathVariable Long id, AdministradorDTO data) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.service.modificarAdminPorId(id, data));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAdministrador(@PathVariable Long id) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.service.eliminarAdministrador(id));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity <?> iniciarSesion(@RequestBody IniciarSesionAdminDTO iniciarSesionDTO) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.service.iniciarSesion(iniciarSesionDTO));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());

        }
    }
}
