package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * HistoriaNivelRepository es el repositorio encargado de gestionar las
 * operaciones CRUD de la entidad historia-oxigeno
 */
@Repository
public interface HistoriaNivelRepository extends ListCrudRepository<HistoriaOxigeno, Integer> {
    @Query("SELECT * FROM historia_oxigeno ORDER BY fecha_hora_medicion DESC LIMIT 5")
    List<HistoriaOxigeno> findLastFive();
}
