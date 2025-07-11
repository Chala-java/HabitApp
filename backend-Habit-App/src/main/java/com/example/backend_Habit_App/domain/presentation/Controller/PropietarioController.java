package com.example.backend_Habit_App.domain.presentation.Controller;


import com.example.backend_Habit_App.domain.application.dto.IniciarSesionDTO;
import com.example.backend_Habit_App.domain.application.dto.PropietarioDTO;
import com.example.backend_Habit_App.domain.application.dto.RegistroPropietarioDTO;
import com.example.backend_Habit_App.domain.application.service.PropietarioService;
import com.example.backend_Habit_App.domain.infrastructure.repository.PropietarioRepository;
import com.example.backend_Habit_App.domain.model.Inquilino;
import com.example.backend_Habit_App.domain.model.Propietario;
import com.example.backend_Habit_App.domain.model.RolEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    @Autowired
    PropietarioService service;

    @Autowired
    PropietarioRepository propietarioRepository;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RegistroPropietarioDTO requestData){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.service.guardarPropietario(requestData));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

@GetMapping
    public ResponseEntity<?> buscarTodosPropietarios (){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.listarPropietarios());
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
@GetMapping("/{id}")
    public ResponseEntity<?> BuscarPropietariosPorID(@PathVariable Long id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.buscarPropietarioPorID(id));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPropietariosPorID(@PathVariable Long id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.service.eliminarPropietarioPorID(id));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarPropietarioPorID(@PathVariable Long id, @RequestBody PropietarioDTO data){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.service.modificarPropietarioPorID(id, data));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    //Inicias Sesion

    @GetMapping("/login")
    public ResponseEntity<?> perfilOAuthPropietario(@AuthenticationPrincipal OAuth2User principal){
        String email = principal.getAttribute("email");
        String nombre = principal.getAttribute("name");

        Optional<Propietario> optionalPropietario= propietarioRepository.findByCorreo(email);
        if (optionalPropietario.isEmpty()) {
            Propietario newPropietario = new Propietario();
            newPropietario.setCorreo(email);
            newPropietario.setNombre(nombre);
            newPropietario.setApellido("NoDefinido");
            newPropietario.setTelefono("0000000");
            newPropietario.setCedula(0L);
            newPropietario.setRol(RolEnum.PROPIETARIO);
            newPropietario.setContrasena("oauth_sin_password");
            propietarioRepository.save(newPropietario);

            return ResponseEntity.ok("Administrador nuevo Registrado desde Oauth0");

        }
        return ResponseEntity.ok(optionalPropietario.get());
    }

    @GetMapping("/bienvenido")
    public String home() {
        return "home"; // Este es el nombre de tu plantilla: home.html en templates
    }

}
