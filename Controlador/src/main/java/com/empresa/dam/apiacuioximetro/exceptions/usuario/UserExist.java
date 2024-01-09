package com.empresa.dam.apiacuioximetro.exceptions.usuario;

public class UserExist extends RuntimeException{
    public UserExist(int id){
        super("Ya existe el usuario con el id" + id);
    }
}
