package com.empresa.dam.apiacuioximetro.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public record Estanques(@Id @Column("idEstanque") int id,
                        @Column("tipoEstanque") String tipoEstanque
){
}
