package com.empresa.dam.apiacuioximetro.service.impl;

import com.empresa.dam.apiacuioximetro.entity.HistorialOxigeno;
import com.empresa.dam.apiacuioximetro.repository.HistoriaNivelRepository;
import com.empresa.dam.apiacuioximetro.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaServiceCrud implements CrudService<HistorialOxigeno> {

    private final HistoriaNivelRepository repository;

    @Autowired
    public HistoriaServiceCrud(HistoriaNivelRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<HistorialOxigeno> findAll() {
        return this.repository.findAll();
    }

    @Override
    public HistorialOxigeno findById(int id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("Historial de oxigeno no encotrado"));
    }

    @Override
    public HistorialOxigeno create(HistorialOxigeno entity) {
        return this.repository.save(entity);
    }

    @Override
    public HistorialOxigeno update(HistorialOxigeno entity) {
        if (!this.repository.existsById(entity.idEstanque())) throw new RuntimeException("Historial de oxigeno no encontrado");
        return this.repository.save(entity);
    }

    @Override
    public boolean deleteById(int id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }
}
