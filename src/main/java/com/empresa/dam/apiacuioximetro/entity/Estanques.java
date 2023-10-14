package com.empresa.dam.apiacuioximetro.entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Esta clase representa la entidad Estanques en la base de datos.
 * 
 * La anotación @Table indica que esta clase está mapeada a una tabla llamada
 * "estanques".
 * 
 * El record Estanques es una clase inmutable que contiene los campos de la
 * tabla como atributos.
 * 
 * La anotación @Id indica que el atributo que le sigue es la clave primaria de
 * la tabla.
 */
@Table("estanques")
public record Estanques(@Id @Column("id_estanque") @NotNull int id,
        @Column("tipo_estanque") @NotNull String tipoEstanque) {
}
