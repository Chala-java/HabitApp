package com.example.backend_Habit_App.domain.infrastructure.repository;

import com.example.backend_Habit_App.domain.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Optional<Administrador> findByCorreo(String correo);
}
