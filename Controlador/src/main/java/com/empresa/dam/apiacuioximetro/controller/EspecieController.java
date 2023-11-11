package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Especie;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.service.EspecieServiceCrud;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/especies")
public class EspecieController {
    private EspecieServiceCrud serviceCrud;

    @GetMapping("/{id}")
    public Especie findById(@PathVariable int id) throws DataNotFoundById {
        return this.serviceCrud.findById(id);
    }
}
