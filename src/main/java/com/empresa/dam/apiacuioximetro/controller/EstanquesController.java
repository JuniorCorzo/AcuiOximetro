package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Estanques;
import com.empresa.dam.apiacuioximetro.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/estanque")
public class EstanquesController extends ApiController<Estanques> {
    public EstanquesController(CrudService<Estanques> serviceCrud) {
        super(serviceCrud);
    }
}
