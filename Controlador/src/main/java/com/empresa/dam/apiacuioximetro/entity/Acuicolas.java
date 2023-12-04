package com.empresa.dam.apiacuioximetro.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("acuicolas")
public record Acuicolas(
        @Column("id_acuicola") @Id @NotNull int idAcuicola,
        @Column("nombre") @NotNull String nombre,
        @Column("direccion") @NotNull String direccion,
        @Column("id_usuario") @NotNull int idUsuario,
        @Column("id_estanque") @NotNull int idEstanque
) {
}
