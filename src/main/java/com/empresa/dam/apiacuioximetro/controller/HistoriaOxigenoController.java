package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import com.empresa.dam.apiacuioximetro.service.CrudService;

public class HistoriaOxigenoController extends ApiController<HistoriaOxigeno> {
    public HistoriaOxigenoController(CrudService<HistoriaOxigeno> serviceCrud){
        super(serviceCrud);
    }
}
