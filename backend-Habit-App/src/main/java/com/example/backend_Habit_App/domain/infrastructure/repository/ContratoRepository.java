package com.example.backend_Habit_App.domain.infrastructure.repository;

import com.example.backend_Habit_App.domain.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
