package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/historia-oxigeno/")
public class HistoriaOxigenoController extends ApiController<HistoriaOxigeno> {
    private CrudService<HistoriaOxigeno> serviceCrud;

    public HistoriaOxigenoController(CrudService<HistoriaOxigeno> serviceCrud){
        super(serviceCrud);
    }

    @GetMapping("/last")
    public List<HistoriaOxigeno> lastFive(){
        return null;
    }
}
