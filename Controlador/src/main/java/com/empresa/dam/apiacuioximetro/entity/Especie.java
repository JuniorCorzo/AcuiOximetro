package com.empresa.dam.apiacuioximetro.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Normalized;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("especie")
public record Especie(@Id @Column("id_especie") @NotNull int id,
                      @Column("nombre") @NotNull @NotEmpty String nombre) {
}
