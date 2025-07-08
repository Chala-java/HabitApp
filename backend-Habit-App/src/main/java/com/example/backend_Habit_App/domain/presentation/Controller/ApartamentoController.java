package com.example.backend_Habit_App.domain.presentation.Controller;

import com.example.backend_Habit_App.domain.application.dto.ApartamentoDTO;
import com.example.backend_Habit_App.domain.application.dto.CrearApartamentoDTO;
import com.example.backend_Habit_App.domain.application.service.ApartamentoService;
import com.example.backend_Habit_App.domain.model.Apartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/apartamento")
public class ApartamentoController {
    @Autowired
    ApartamentoService apartamentoService;

    @PostMapping
    public ResponseEntity<?> guardarApartamento(@RequestBody  CrearApartamentoDTO datos){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.apartamentoService.guardarApartamento(datos));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarApartamento(){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.apartamentoService.listarApartamento());
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarApartamentoPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.apartamentoService.buscarApartamentoPorId(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifcarApartamentoPorId(@PathVariable Long id, @RequestBody Apartamento datos) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.apartamentoService.modificarApartamentoPorId(id, datos));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarApartamentoPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.apartamentoService.eliminarApartamentoPorId(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }
































}
