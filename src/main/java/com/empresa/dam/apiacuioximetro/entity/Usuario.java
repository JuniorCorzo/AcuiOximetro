package com.empresa.dam.apiacuioximetro.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("usuario")
public record Usuario(@Id
                      @Column("id_usuario")
                      @NotNull
                      int idUsuario,
                      @Column("rol")
                      @NotNull
                      @NotEmpty
                      String rol,
                      @Column("nombre")
                      @NotNull
                      @NotEmpty
                      String nombre,
                      @Column("apellido")
                      @NotNull
                      @NotEmpty
                      String apellido,
                      @Column("correo")
                      @NotNull
                      @NotEmpty
                      @Email
                      String correo,
                      @Column("clave")
                      @NotNull
                      @NotEmpty
                      String clave
) {
}
