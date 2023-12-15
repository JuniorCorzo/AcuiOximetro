package com.empresa.dam.apiacuioximetro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="Acuicolas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Acuicolas {
    @Column(name = "id_acuicola")
    @Id
    @NotNull
    private int idAcuicola;
    @Column(name = "nombre")
    @NotNull
    private String nombre;
    @Column(name = "direccion")
    @NotNull
    private String direccion;
    @Column(name = "id_usuario")
    @NotNull
    private int idUsuario;
    @Column(name = "id_estanque")
    @NotNull
    private int idEstanque;
}
