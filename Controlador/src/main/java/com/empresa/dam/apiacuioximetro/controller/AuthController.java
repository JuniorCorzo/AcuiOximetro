package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.dto.AuthenticationRequest;
import com.empresa.dam.apiacuioximetro.dto.AuthenticationResponse;
import com.empresa.dam.apiacuioximetro.service.AuthenticationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Genera un token de autenticación para el usuario que realiza la petición.
 *
 * @param authentication Objeto que contiene la información de autenticación del usuario.
 * @return El token generado.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private final AuthenticationService authenticationService;
    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authenticationRequest) {
        AuthenticationResponse jwtDto = authenticationService.login(authenticationRequest);
        return ResponseEntity.ok(jwtDto);
    }
}
