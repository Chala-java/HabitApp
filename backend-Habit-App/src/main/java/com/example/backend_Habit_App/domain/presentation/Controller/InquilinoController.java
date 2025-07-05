package com.example.backend_Habit_App.domain.presentation.Controller;

import com.example.backend_Habit_App.domain.application.dto.IniciarSesionDTO;
import com.example.backend_Habit_App.domain.application.dto.InquilinoDTO;
import com.example.backend_Habit_App.domain.application.dto.RegistroInquilinoDTO;
import com.example.backend_Habit_App.domain.application.dto.RegistroPropietarioDTO;
import com.example.backend_Habit_App.domain.application.service.InquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inquilinos")
public class InquilinoController {

    @Autowired
    InquilinoService inquilinoService;

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

    @PostMapping("/Login")
    public ResponseEntity<?> inicioSesion(@RequestBody IniciarSesionDTO inciarSesionDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.inquilinoService.iniciarSesion(inciarSesionDTO));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error.getMessage());
        }
    }

}
