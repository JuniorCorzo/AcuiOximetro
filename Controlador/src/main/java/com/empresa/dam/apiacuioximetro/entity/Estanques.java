package com.empresa.dam.apiacuioximetro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * Esta clase representa la entidad Estanques en la base de datos.
 * <p>
 * La anotación @Table indica que esta clase está mapeada a una tabla llamada
 * "estanques".
 * <p>
 * El record Estanques es una clase inmutable que contiene los campos de la
 * tabla como atributos.
 * <p>
 * La anotación @Id indica que el atributo que le sigue es la clave primaria de
 * la tabla.
 */
@Entity
@Table(name = "estanques")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estanques {
    @Id
    @Column(name = "id_estanques")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_especie")
    private int idEspecie;
    @Column(name = "tipo_estanque")
    @NotNull
    private String tipoEstanque;
    @Column(name = "cantidad_peces")
    private int cantidadPeces;

}
