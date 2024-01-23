package com.empresa.dam.apiacuioximetro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "especies")
@NoArgsConstructor
@AllArgsConstructor
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
