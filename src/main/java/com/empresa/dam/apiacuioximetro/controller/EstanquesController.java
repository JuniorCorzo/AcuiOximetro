package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Estanques;
import com.empresa.dam.apiacuioximetro.service.CrudService;

public class EstanquesController extends ApiController<Estanques> {
    public EstanquesController(CrudService<Estanques> serviceCrud) {
        super(serviceCrud);
    }
}
