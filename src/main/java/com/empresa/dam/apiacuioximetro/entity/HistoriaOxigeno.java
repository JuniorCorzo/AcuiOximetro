package com.empresa.dam.apiacuioximetro.entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

/**
 * Esta clase representa la entidad HistoriaOxigeno en la base de datos.
 * La anotación @Table indica que esta clase está mapeada a la tabla
 * "historia_oxigeno".
 * La anotación @Id indica que el atributo que le sigue es la clave primaria de
 * la tabla.
 */
@Table("historia_oxigeno")
public record HistoriaOxigeno(@Id @Column("id_estanques") @NotNull int idEstanque,
        @Column("nivel_oxigenacion") @NotNull double nivelOxigenacion,
        @Column("fecha_hora_medicion") @NotNull Date fechaMedicion) {
}
