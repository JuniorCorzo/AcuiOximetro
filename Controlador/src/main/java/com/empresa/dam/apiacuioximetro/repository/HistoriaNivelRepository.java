package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * HistoriaNivelRepository es el repositorio encargado de gestionar las
 * operaciones CRUD de la entidad historia-oxigeno
 */
@Repository
public interface HistoriaNivelRepository extends JpaRepository<HistoriaOxigeno, Integer> {
    @Query(value = "SELECT * FROM historia_oxigeno ORDER BY fecha_hora_medicion DESC LIMIT 5", nativeQuery = true)
    List<HistoriaOxigeno> findLastFive();

    List<HistoriaOxigeno> findAllByIdEstanque(@NotNull int idEstanque);
}
