package com.empresa.dam.apiacuioximetro.service.impl;

import com.empresa.dam.apiacuioximetro.entity.Estanques;
import com.empresa.dam.apiacuioximetro.repository.EstanquesRepository;
import com.empresa.dam.apiacuioximetro.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstanquesServiceCrud implements CrudService<Estanques> {
    private final EstanquesRepository repository;

    @Autowired
    public EstanquesServiceCrud(EstanquesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estanques> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Estanques findById(int id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el id del estanque"));
    }

    @Override
    public Estanques create(Estanques entity) {
        return this.repository.save(entity);
    }

    @Override
    public Estanques update(Estanques entity) {
        if(!this.repository.existsById(entity.id())) throw new RuntimeException("No se encontro el estanque a actualizar");
        return this.repository.save(entity);
    }

    @Override
    public boolean deleteById(int id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }
}
