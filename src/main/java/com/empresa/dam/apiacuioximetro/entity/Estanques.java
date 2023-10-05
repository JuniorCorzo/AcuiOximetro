package com.empresa.dam.apiacuioximetro.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public record Estanques(@Id @Column("id_estanques") int id,
                        @Column("tipo_estanque") String tipoEstanque
){
}
