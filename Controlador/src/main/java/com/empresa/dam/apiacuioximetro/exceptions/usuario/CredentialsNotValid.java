package com.empresa.dam.apiacuioximetro.exceptions.usuario;

public class CredentialsNotValid extends Exception{
    public CredentialsNotValid() {
        super("Correo o Contraseña incorrectos");
    }
}
