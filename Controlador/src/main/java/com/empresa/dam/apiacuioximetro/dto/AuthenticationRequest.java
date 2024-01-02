package com.empresa.dam.apiacuioximetro.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    private String nombre;
    private String clave;
}
