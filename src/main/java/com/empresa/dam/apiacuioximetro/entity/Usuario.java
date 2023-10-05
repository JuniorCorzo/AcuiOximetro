package com.empresa.dam.apiacuioximetro.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("usuario")
public record Usuario(@Id @Column("id_usuario") int idUsuario,
                      @Column("rol") String rol,
                      @Column("nombre") String nombre,
                      @Column("apellido") String apellido,
                      @Column("correo") String correo,
                      @Column("clave") String clave
                      ) {
}
