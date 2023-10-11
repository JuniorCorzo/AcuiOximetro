package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import com.empresa.dam.apiacuioximetro.service.HistoriaServiceCrud;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/historia")
public class HistoriaController {
    private final HistoriaServiceCrud serviceCrud;
    public HistoriaController(HistoriaServiceCrud serviceCrud) {
        this.serviceCrud = serviceCrud;
    }

    @GetMapping
    public List<HistoriaOxigeno> findAll(){
        return serviceCrud.findAll();
    }

    @GetMapping("/{id}")
    public HistoriaOxigeno findById(@PathVariable int id){
        return this.serviceCrud.findById(id);
    }

    @GetMapping("/five")
    public List<HistoriaOxigeno> findLastFive(){
        return this.serviceCrud.findLasFive();
    }
}
