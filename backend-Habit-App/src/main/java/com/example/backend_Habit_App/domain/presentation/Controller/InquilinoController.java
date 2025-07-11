package com.example.backend_Habit_App.domain.presentation.Controller;

import com.example.backend_Habit_App.domain.application.dto.IniciarSesionDTO;
import com.example.backend_Habit_App.domain.application.dto.InquilinoDTO;
import com.example.backend_Habit_App.domain.application.dto.RegistroInquilinoDTO;
import com.example.backend_Habit_App.domain.application.dto.RegistroPropietarioDTO;
import com.example.backend_Habit_App.domain.application.service.InquilinoService;
import com.example.backend_Habit_App.domain.infrastructure.repository.InquilinoRepository;
import com.example.backend_Habit_App.domain.model.Administrador;
import com.example.backend_Habit_App.domain.model.Inquilino;
import com.example.backend_Habit_App.domain.model.RolEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/inquilinos")
public class InquilinoController {

    @Autowired
    InquilinoService inquilinoService;

    @Autowired
    InquilinoRepository inquilinoRepository;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RegistroInquilinoDTO requestData){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.inquilinoService.guardarInquilino(requestData));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarInquilinos(){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.inquilinoService.listarInquilino());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarInquilinoById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.inquilinoService.buscarInquilinoById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarInquilinoPorId(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.inquilinoService.eliminarInquilinoById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarInquilinoPorId(@PathVariable Long id,@RequestBody InquilinoDTO datosInquilino){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.inquilinoService.modificarInquilinoById(id, datosInquilino));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }




    @GetMapping("/login")
    public ResponseEntity<?> perfilOAuthInquilino(@AuthenticationPrincipal OAuth2User principal){
        String email = principal.getAttribute("email");
        String nombre = principal.getAttribute("name");

        Optional<Inquilino> optionalInquilino = inquilinoRepository.findByCorreo(email);
        if (optionalInquilino.isEmpty()) {
            Inquilino newInquilino = new Inquilino();
            newInquilino.setCorreo(email);
            newInquilino.setNombre(nombre);
            newInquilino.setApellido("NoDefinido");
            newInquilino.setTelefono("0000000");
            newInquilino.setCedula(0L);
            newInquilino.setRol(RolEnum.INQUILINO);
            newInquilino.setContrasena("oauth_sin_password");
            inquilinoRepository.save(newInquilino);

            return ResponseEntity.ok("Administrador nuevo Registrado desde Oauth0");

        }
        return ResponseEntity.ok(optionalInquilino.get());
    }


    @GetMapping("/bienvenido")
    public String home() {
        return "home"; // Este es el nombre de tu plantilla: home.html en templates
    }


}
