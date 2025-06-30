package com.example.backend_Habit_App.domain.infrastructure.repository;

import com.example.backend_Habit_App.domain.model.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropietarioRepository extends JpaRepository <Propietario, Long> {
    Optional<Propietario> findByCorreo(String correo);
}
