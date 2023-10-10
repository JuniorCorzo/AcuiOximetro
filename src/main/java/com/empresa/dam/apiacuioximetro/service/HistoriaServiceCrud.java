package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import com.empresa.dam.apiacuioximetro.repository.HistoriaNivelRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@NoArgsConstructor
public class HistoriaServiceCrud {
    private HistoriaNivelRepository repository;

    @Autowired
    public HistoriaServiceCrud(HistoriaNivelRepository repository) {
        this.repository = repository;
    }

    public List<HistoriaOxigeno> findAll() {
        return this.repository.findAll();
    }

    public HistoriaOxigeno findById(int id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Historial de oxigeno no encotrado"));
    }

    public HistoriaOxigeno create(HistoriaOxigeno entity) {
        return this.repository.save(entity);
    }

    public HistoriaOxigeno update(HistoriaOxigeno entity) {
        if (!this.repository.existsById(entity.idEstanque()))
            throw new RuntimeException("Historial de oxigeno no encontrado");
        return this.repository.save(entity);
    }

    public boolean deleteById(int id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }

    public List<HistoriaOxigeno> findLasFive() {
        return this.repository.findLastFive();
    }
}
