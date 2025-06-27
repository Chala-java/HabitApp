package com.example.backend_Habit_App.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "inquilino")

public class Inquilino extends UsuarioBase {
    public Inquilino(){
        super();
    }




}
