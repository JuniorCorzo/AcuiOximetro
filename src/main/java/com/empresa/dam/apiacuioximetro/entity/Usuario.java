package com.empresa.dam.apiacuioximetro.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public record Usuario(@Id int idUsuario,
                      @Column("rol") String rol,
                      @Column("nombre") String nombre,
                      @Column("apellido") String apellido,
                      @Column("correo") String correo,
                      @Column("contraseña") String clave
                      ) {
}
