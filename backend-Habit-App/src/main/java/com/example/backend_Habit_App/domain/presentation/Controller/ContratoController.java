package com.example.backend_Habit_App.domain.presentation.Controller;

import com.example.backend_Habit_App.domain.application.dto.ContratoDTO;
import com.example.backend_Habit_App.domain.application.dto.CrearContratoDTO;
import com.example.backend_Habit_App.domain.application.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contrato")
public class ContratoController {

    @Autowired
    ContratoService contratoService;

    @PostMapping
    public ResponseEntity<?> crearContrato (@RequestBody CrearContratoDTO datosContrato){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.contratoService.crearContrato(datosContrato));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?>listarContrato(){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.contratoService.listarContratos());
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> buscarContratoPorId(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.contratoService.buscarContratoPorId(id));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarContratoPorId(@PathVariable Long id, ContratoDTO datosContrato){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.contratoService.modificarContratoPorId(id, datosContrato));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarContratoPorId(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.contratoService.eliminarContratoPorId(id));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    }
