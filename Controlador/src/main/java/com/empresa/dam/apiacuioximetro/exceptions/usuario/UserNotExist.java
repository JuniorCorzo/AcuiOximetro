package com.empresa.dam.apiacuioximetro.exceptions.usuario;

public class UserNotExist extends RuntimeException{
    public UserNotExist(int id) {
        super("No se ha encontrado el usuario con id: " + id);
    }
}
