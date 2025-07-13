package com.example.backend_Habit_App.domain.infrastructure.repository;

import com.example.backend_Habit_App.domain.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}
