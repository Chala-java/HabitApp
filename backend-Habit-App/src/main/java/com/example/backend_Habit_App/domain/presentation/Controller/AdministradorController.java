package com.example.backend_Habit_App.domain.presentation.Controller;

import com.example.backend_Habit_App.domain.application.dto.AdministradorDTO;
import com.example.backend_Habit_App.domain.application.dto.IniciarSesionAdminDTO;
import com.example.backend_Habit_App.domain.application.dto.RegistroAdminDTO;
import com.example.backend_Habit_App.domain.application.service.AdministradorService;
import com.example.backend_Habit_App.domain.infrastructure.repository.AdministradorRepository;
import com.example.backend_Habit_App.domain.model.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

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

    @Autowired
    AdministradorRepository administradorRepository;


    @GetMapping("/login")
    public ResponseEntity<?> perfilOAuth(@AuthenticationPrincipal OAuth2User principal){
        String email = principal.getAttribute("email");
        String nombre = principal.getAttribute("name");

        Optional<Administrador> optionalAdmin = administradorRepository.findByCorreo(email);
        if (optionalAdmin.isEmpty()) {
            Administrador newAdmin = new Administrador();
            newAdmin.setCorreo(email);
            newAdmin.setNombre(nombre);
            newAdmin.setApellido("NoDefinido");
            newAdmin.setTelefono("0000000");
            newAdmin.setCedula(0L);
            newAdmin.setContrasena("oauth_sin_password");

            administradorRepository.save(newAdmin);

            return ResponseEntity.ok("Administrador nuevo Registrado desde Oauth0");

        }
        return ResponseEntity.ok(optionalAdmin.get());
    }


    @GetMapping("/bienvenido")
    public String home() {
        return "home"; // Este es el nombre de tu plantilla: home.html en templates
    }



}
