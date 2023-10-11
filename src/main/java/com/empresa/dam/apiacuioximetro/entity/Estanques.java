package com.empresa.dam.apiacuioximetro.entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("estanques")
public record Estanques(@Id
                        @Column("id_estanque")
                        @NotNull
                        int id,
                        @Column("tipo_estanque")
                        @NotNull
                        String tipoEstanque
){
}
