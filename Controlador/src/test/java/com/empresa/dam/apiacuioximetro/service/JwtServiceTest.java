package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import com.empresa.dam.apiacuioximetro.utils.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JwtServiceTest {
    @Autowired
    private JwtService jwtService;

    @Test
    void JwtService_CreateToken_ReturnTokenCreated() {
        Usuarios usuario = Usuarios.builder()
                .idUsuario(1234567890)
                .rol(Role.ADMINISTRADOR)
                .nombre("Angel")
                .apellido("Corzo")
                .correo("prueba@gmail.com")
                .password("1234")
                .build();

        String tokenCreated = jwtService.generateToken(usuario, generateExtraClaims(usuario));

        Assertions.assertNotNull(tokenCreated);
        Assertions.assertEquals(3, tokenCreated.split("\\.").length);
    }

    @Test
    void JwtService_ExtractUsername_ReturnUsername() {
        Usuarios usuario = Usuarios.builder()
                .idUsuario(1234567890)
                .rol(Role.ADMINISTRADOR)
                .nombre("Angel")
                .apellido("Corzo")
                .correo("prueba@gmail.com")
                .password("1234")
                .build();

        String extractedUsername = jwtService.extractUsername(jwtService.generateToken(usuario, generateExtraClaims(usuario)));

        Assertions.assertNotNull(extractedUsername);
        Assertions.assertEquals("Angel", extractedUsername);
    }

    private Map<String, Object> generateExtraClaims(Usuarios usuarios) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", usuarios.getNombre());
        extraClaims.put("role", usuarios.getRol().name());
        extraClaims.put("permissions", usuarios.getAuthorities());

        return extraClaims;
    }
}