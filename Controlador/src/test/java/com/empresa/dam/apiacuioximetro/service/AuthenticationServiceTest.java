package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.dto.AuthenticationRequest;
import com.empresa.dam.apiacuioximetro.dto.AuthenticationResponse;
import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import com.empresa.dam.apiacuioximetro.utils.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class})
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AuthenticationServiceTest {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AuthenticationService authService;

    @Test
    void AuthenticationService_Login_ValidatedLogin() {
        Usuarios usuario = Usuarios.builder()
                .idUsuario(1234567890)
                .rol(Role.ADMINISTRADOR)
                .nombre("Angel")
                .apellido("Corzo")
                .correo("prueba@gmail.com")
                .clave(new BCryptPasswordEncoder().encode("1234"))
                .build();
        usuarioRepository.save(usuario);
        AuthenticationRequest authRequest = new AuthenticationRequest();
        authRequest.setNombre(usuario.getNombre());
        authRequest.setClave("1234");

        AuthenticationResponse authResponse = authService.login(authRequest);

        Assertions.assertNotNull(authResponse);
    }
}