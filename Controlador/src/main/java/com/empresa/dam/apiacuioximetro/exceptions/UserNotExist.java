package com.empresa.dam.apiacuioximetro.exceptions;

public class UserNotExist extends Exception{
    public UserNotExist(int id) {
        super("No se ha encontrado el usuario con id: " + id);
    }

    public UserNotExist(String correo) {
        super("No se ha encontrado el usuario con el correo: " + correo);
    }
}
