package com.empresa.dam.apiacuioximetro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Esta clase representa la entidad HistoriaOxigeno en la base de datos.
 * La anotación @Table indica que esta clase está mapeada a la tabla
 * "historia_oxigeno".
 * La anotación @Id indica que el atributo que le sigue es la clave primaria de
 * la tabla.
 */
@Entity
@Table(name = "historia_oxigeno")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaOxigeno {
    @Id
    @Column(name = "id_estanques")
    @NotNull
    private int idEstanque;
    @Column(name = "nivel_oxigenacion")
    @NotNull
    private double nivelOxigenacion;
    @Column(name = "fecha_hora_medicion")
    @NotNull
    private Date fechaMedicion;
}
