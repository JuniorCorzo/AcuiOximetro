package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Especies;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.service.EspecieServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/especies")
public class EspecieController {
    private final EspecieServiceCrud serviceCrud;

    @Autowired
    public EspecieController(EspecieServiceCrud serviceCrud) {
        this.serviceCrud = serviceCrud;
    }

    @GetMapping("/{id}")
    public Especies findById(@PathVariable int id) throws DataNotFoundById {
        return this.serviceCrud.getById(id);
    }
}
