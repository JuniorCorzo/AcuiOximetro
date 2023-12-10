package com.empresa.dam.apiacuioximetro.exceptions;

public class DataNotFound extends Exception{
    public DataNotFound(String message) {
        super("La entidad " + message + "no tiene almacenada datos");
    }
}
