package com.example.backend_Habit_App.domain.presentation.Controller;


import com.example.backend_Habit_App.domain.application.dto.IniciarSesionDTO;
import com.example.backend_Habit_App.domain.application.dto.PropietarioDTO;
import com.example.backend_Habit_App.domain.application.dto.RegistroPropietarioDTO;
import com.example.backend_Habit_App.domain.application.service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    @Autowired
    PropietarioService service;

    @PostMapping("/registro")
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

    @PostMapping("/login")
    public ResponseEntity<?> iniciarSesion (@RequestBody IniciarSesionDTO iniciarSesionDTO){
        try {
            return
                    ResponseEntity.status(HttpStatus.CREATED)
                            .body(service.iniciarSesion(iniciarSesionDTO));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(error.getMessage());
        }
    }

}
