package com.example.backend_Habit_App.domain.presentation.Controller;

import com.example.backend_Habit_App.domain.application.dto.CrearEdificioDTO;
import com.example.backend_Habit_App.domain.application.dto.EdificioDTO;
import com.example.backend_Habit_App.domain.application.service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/edificio")
public class EdificioController {
    @Autowired
    EdificioService edificioService;

    @PostMapping
    public ResponseEntity<?> guardarEdificio(@RequestBody CrearEdificioDTO datos) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.edificioService.guardarEdificio(datos));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarEdificios() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(edificioService.listarEdificios());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarEdificioPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(edificioService.buscarEdificioById(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarEdificioPorId(@PathVariable Long id, @RequestBody EdificioDTO datos) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(edificioService.modificarEdificioById(id, datos));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEdificioPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(edificioService.eliminarEdificioById(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }
    }

}
