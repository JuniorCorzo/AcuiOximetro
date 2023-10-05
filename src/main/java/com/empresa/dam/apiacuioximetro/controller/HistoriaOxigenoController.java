package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import com.empresa.dam.apiacuioximetro.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/historia-oxigeno/")
public class HistoriaOxigenoController extends ApiController<HistoriaOxigeno> {
    public HistoriaOxigenoController(CrudService<HistoriaOxigeno> serviceCrud){
        super(serviceCrud);
    }
}
