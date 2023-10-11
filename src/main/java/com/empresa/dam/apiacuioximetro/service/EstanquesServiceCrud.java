package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Estanques;
import com.empresa.dam.apiacuioximetro.repository.EstanquesRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class EstanquesServiceCrud{
    private EstanquesRepository repository;

    @Autowired
    public EstanquesServiceCrud(EstanquesRepository repository) {
        this.repository = repository;
    }

    
    public List<Estanques> findAll() {
        return this.repository.findAll();
    }

    
    public Estanques findById(int id) {
        return this.repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el id del estanque"));
    }

    
    public void create(Estanques entity) {
        this.repository.save(entity);
    }

    
    public void update(Estanques entity) {
        if(!this.repository.existsById(entity.id())) throw new RuntimeException("No se encontro el estanque a actualizar");
        this.repository.save(entity);
    }

    
    public boolean deleteById(int id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }
}
