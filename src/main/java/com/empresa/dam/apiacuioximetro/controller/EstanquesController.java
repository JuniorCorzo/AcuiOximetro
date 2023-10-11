package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Estanques;
import com.empresa.dam.apiacuioximetro.service.EstanquesServiceCrud;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estanques")
public class EstanquesController {
    private final EstanquesServiceCrud serviceCrud;

    public EstanquesController(EstanquesServiceCrud serviceCrud) {
        this.serviceCrud = serviceCrud;
    }

    @GetMapping
    public List<Estanques> findAll(){
        return this.serviceCrud.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void create(@Valid @RequestBody Estanques estanques){
        this.serviceCrud.create(estanques);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update")
    public void update(@Valid @RequestBody Estanques estanques){
        this.serviceCrud.update(estanques);
    }

}
