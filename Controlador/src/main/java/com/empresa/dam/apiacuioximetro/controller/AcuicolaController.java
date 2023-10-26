package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Acuicula;
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
    public Acuicula findById(@PathVariable int id){
        return this.serviceCrud.findById(id);
    }
}
