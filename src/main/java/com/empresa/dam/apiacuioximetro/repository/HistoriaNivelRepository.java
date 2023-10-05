package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.HistorialOxigeno;
import org.springframework.data.repository.ListCrudRepository;

public interface HistoriaNivelRepository extends ListCrudRepository<HistorialOxigeno, Integer> {
}
