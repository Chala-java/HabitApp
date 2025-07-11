package com.example.backend_Habit_App.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final SecretKey secretKey = Keys.hmacShaKeyFor( "clave-super-secreta-muy-larga-de-al-menos-32-bytes".getBytes());

    public String generarToken(String correo, String rol){
        return Jwts.builder()
                .subject(correo)
                .claim("rol", rol)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 *60 * 60))
                .signWith(secretKey, Jwts.SIG.HS256)
                .compact();
    }

    public boolean  validarToken(String token){
        try {
       Jwts.parser()
               .verifyWith(secretKey)
               .build()
               .parseSignedClaims(token);
       return true;
        }catch (JwtException error){
            return false;
        }
    }

    public String obtenerCorreoDesdeToken(String token){
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String obtenerRolDesdeToken(String token){
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("rol", String.class);
    }


}
