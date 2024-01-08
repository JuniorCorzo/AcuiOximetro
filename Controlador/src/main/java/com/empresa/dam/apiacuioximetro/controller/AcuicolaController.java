package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Acuicolas;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.service.AcuicolaServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/acuicolas")
public class AcuicolaController {
    private final AcuicolaServiceCrud serviceCrud;

    @Autowired
    public AcuicolaController(AcuicolaServiceCrud serviceCrud) {
        this.serviceCrud = serviceCrud;
    }

    @GetMapping("/{id}")
    public Acuicolas getById(@PathVariable int id) throws DataNotFoundById {
        return this.serviceCrud.getById(id);
    }
}