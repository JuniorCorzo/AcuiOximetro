package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.dto.AuthenticationRequest;
import com.empresa.dam.apiacuioximetro.dto.AuthenticationResponse;
import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
    }

    public AuthenticationResponse login(AuthenticationRequest authRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authRequest.getNombre(), authRequest.getClave());

        authenticationManager.authenticate(authToken);
        //No usar UsuarioRepository usar mejor UsuarioService
        Usuarios usuario = usuarioRepository.findByNombre(authRequest.getNombre()).get();

        String jwt = jwtService.generateToken(usuario, generateExtraClaims(usuario));

        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object> generateExtraClaims(Usuarios usuarios) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", usuarios.getNombre());
        extraClaims.put("role", usuarios.getRol().name());
        extraClaims.put("permissions", usuarios.getAuthorities());

        return extraClaims;
    }
}
