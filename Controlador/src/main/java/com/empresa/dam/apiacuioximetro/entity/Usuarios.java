package com.empresa.dam.apiacuioximetro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {
    // Identificador único del usuario.
    @Id
    @Column(name = "id_usuario")
    @NotNull
    private int idUsuario;

    // Rol del usuario en el sistema.

    @Column(name = "rol")
    @NotNull
    @NotEmpty
    private String rol;

    // Nombre del usuario.

    @Column(name = "nombre")
    @NotNull
    @NotEmpty
    private String nombre;

    // Apellido del usuario.
    @Column(name = "apellido")
    @NotNull
    @NotEmpty
    private String apellido;

    // Correo electrónico del usuario.

    @Column(name = "correo")
    @NotNull
    @NotEmpty
    @Email
    private String correo;

    // Clave de acceso del usuario.

    @Column(name = "clave")
    @NotNull
    @NotEmpty
    private String clave;
    @Column(name = "token")
    private String token;
}
