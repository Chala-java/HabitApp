package com.example.backend_Habit_App.domain.infrastructure.repository;

import com.example.backend_Habit_App.domain.model.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface InquilinoRepository extends JpaRepository<Inquilino,Long> {
Optional<Inquilino>findByCorreo(String correo);
}
