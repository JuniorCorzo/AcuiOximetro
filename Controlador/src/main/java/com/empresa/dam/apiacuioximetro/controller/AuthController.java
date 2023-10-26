package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
    * Genera un token de autenticación para el usuario que realiza la petición.
    * 
    * @param authentication Objeto que contiene la información de autenticación del usuario.
    * @return El token generado.
    */
@RestController
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication){
        LOG.debug("Peticion de token por el usuario: '{}'", authentication.getName());
        String token = tokenService.generatedToken(authentication);
        LOG.debug("Token garantizado a : '{}'", authentication.getName());
        return token;
    }

}
