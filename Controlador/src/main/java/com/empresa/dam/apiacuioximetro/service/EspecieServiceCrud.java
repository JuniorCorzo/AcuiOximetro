package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Especie;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.repository.EspecieRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class EspecieServiceCrud {

    private EspecieRepository repository;

    @Autowired
    public EspecieServiceCrud(EspecieRepository repository) {
        this.repository = repository;
    }

    public Especie findById(int id) throws DataNotFoundById {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundById("Especie", id));
    }

    public void create(Especie especie){
        repository.save(especie);
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
