package com.empresa.dam.apiacuioximetro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "especies")
@Data
public class Especies {
    @Id
    @Column(name = "id_especie")
    @NotNull
    private int id;
    @Column(name = "nombre")
    @NotNull
    @NotEmpty
    private String nombre;
}
