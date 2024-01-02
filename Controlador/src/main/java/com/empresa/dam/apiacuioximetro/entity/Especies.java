package com.empresa.dam.apiacuioximetro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "especies")
@Data
@Builder
public class Especies {
    @Id
    @Column(name = "id_especie")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    @NotNull
    @NotEmpty
    private String nombre;
}
