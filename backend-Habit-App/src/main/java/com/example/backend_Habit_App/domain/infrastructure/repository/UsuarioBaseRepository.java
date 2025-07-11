package com.example.backend_Habit_App.domain.infrastructure.repository;

import com.example.backend_Habit_App.domain.model.UsuarioBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioBaseRepository extends JpaRepository<UsuarioBase, Long> {
    Optional<UsuarioBase> findByCorreo(String correo);
}
