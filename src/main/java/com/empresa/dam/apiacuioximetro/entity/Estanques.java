package com.empresa.dam.apiacuioximetro.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("estanques")
public record Estanques(@Id @Column("id_estanque") int id,
                        @Column("tipo_estanque") String tipoEstanque
){
}
