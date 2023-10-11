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

    public List<HistoriaOxigeno> findLasFive() {
        return this.repository.findLastFive();
    }
}
