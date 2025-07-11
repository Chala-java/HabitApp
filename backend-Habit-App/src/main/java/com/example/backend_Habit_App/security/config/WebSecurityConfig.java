package com.example.backend_Habit_App.security.config;

import com.example.backend_Habit_App.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/api/propietario/**").hasAuthority("PROPIETARIO")
                        .requestMatchers("/api/inquilino/**").hasAuthority("INQUILINO")
                        .requestMatchers("/api/administrador/**").hasAuthority("ADMINISTRADOR")

                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/api/administrador/login",true)
                );
        return http.build();
    }
}
