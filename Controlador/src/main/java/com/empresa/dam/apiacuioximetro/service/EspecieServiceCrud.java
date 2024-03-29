package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.dto.EspecieDTO;
import com.empresa.dam.apiacuioximetro.entity.Especies;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.repository.EspecieRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class EspecieServiceCrud {

    private EspecieRepository repository;

    @Autowired
    public EspecieServiceCrud(EspecieRepository repository) {
        this.repository = repository;
    }

    public Especies getById(int id) throws DataNotFoundById {
        return this.repository.findById(id).orElseThrow(() -> new DataNotFoundById("Especie", id));
    }

    public List<EspecieDTO> getAllNombres(){
        return this.repository.findAllNombre();
    }
}
