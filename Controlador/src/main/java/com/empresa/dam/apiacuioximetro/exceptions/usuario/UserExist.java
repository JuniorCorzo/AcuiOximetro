package com.empresa.dam.apiacuioximetro.exceptions.usuario;

public class UserExist extends Exception{
    public UserExist(int id){
        super("Ya existe el usuario con el id" + id);
    }
}
