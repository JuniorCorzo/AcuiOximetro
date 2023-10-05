package com.empresa.dam.apiacuioximetro.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

public record HistorialOxigeno(@Id @Column("id_estanques") int idEstanque,
                               @Column("nivel_oxigenacion") int nivelOxigenacion,
                               @Column("fecha_hora_medicion")Date fechaMedicion
) {
}
