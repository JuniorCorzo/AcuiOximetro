package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Acuicolas;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.repository.AcuicolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcuicolaServiceCrud {

    private final AcuicolaRepository repository;

    @Autowired
    public AcuicolaServiceCrud(AcuicolaRepository repository) {
        this.repository = repository;
    }

    public Acuicolas findById(int id) throws DataNotFoundById {
        return this.repository.findById(id).orElseThrow(() -> new DataNotFoundById("Acuicolas", id));
    }
}
