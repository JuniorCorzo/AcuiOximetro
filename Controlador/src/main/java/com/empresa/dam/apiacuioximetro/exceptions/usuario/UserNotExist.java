package com.empresa.dam.apiacuioximetro.exceptions.usuario;

public class UserNotExist extends Exception{
    public UserNotExist(int id) {
        super("No se ha encontrado el usuario con id: " + id);
    }
}
