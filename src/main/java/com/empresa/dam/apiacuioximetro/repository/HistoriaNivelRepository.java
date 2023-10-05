package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaNivelRepository extends ListCrudRepository<HistoriaOxigeno, Integer> {
}
