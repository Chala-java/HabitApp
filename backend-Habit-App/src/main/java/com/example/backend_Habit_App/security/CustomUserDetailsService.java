package com.example.backend_Habit_App.security;

import com.example.backend_Habit_App.domain.infrastructure.repository.UsuarioBaseRepository;
import com.example.backend_Habit_App.domain.model.UsuarioBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioBaseRepository usuarioBaseRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        UsuarioBase usuarioBase = usuarioBaseRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo" + correo));

        return new org.springframework.security.core.userdetails.User(
                usuarioBase.getCorreo(),
                usuarioBase.getContrasena(),
                getAuthorities(usuarioBase.getRol().name())
        );
    }
        private Collection<? extends GrantedAuthority> getAuthorities(String rol) {
            return List.of(new SimpleGrantedAuthority("ROLE_" + rol)); // Ej: ROLE_ADMINISTRADOR
    }
}
