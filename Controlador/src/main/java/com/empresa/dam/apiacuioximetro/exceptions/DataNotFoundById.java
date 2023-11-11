package com.empresa.dam.apiacuioximetro.exceptions;

public class DataNotFoundById extends Exception{
    public DataNotFoundById(String message, int id) {
        super("No se ha encontrado el dato con id: " + id + " en la tabla " + message);
    }
}
