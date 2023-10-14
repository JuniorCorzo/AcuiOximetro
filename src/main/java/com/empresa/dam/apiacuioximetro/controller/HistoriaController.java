package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import com.empresa.dam.apiacuioximetro.service.HistoriaServiceCrud;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador encargado de gestionar las operaciones CRUD para la entidad
 * HistoriaOxigeno.
 */
@RestController
@RequestMapping("api/v1/historia")
public class HistoriaController {
    private final HistoriaServiceCrud serviceCrud;

    /**
     * Constructor de la clase HistoriaController.
     * 
     * @param serviceCrud servicio que provee los métodos para realizar las
     *                    operaciones CRUD.
     */
    public HistoriaController(HistoriaServiceCrud serviceCrud) {
        this.serviceCrud = serviceCrud;
    }

    /**
     * 
     * Metodo HTTP GET que devuelve una lista que contenga todos los datos
     * almacenados en la base de datos.
     * 
     * @return lista de objetos HistoriaOxigeno.
     */
    @GetMapping
    public List<HistoriaOxigeno> findAll() {
        return serviceCrud.findAll();
    }

    /**
     * Metodo HTTP GET que busca y devuelve la historia de oxígeno con el ID
     * especificado.
     * 
     * @param id el ID del nivel de oxígeno a buscar.
     * @return el nivel de oxigeno con el ID especificado.
     */
    @GetMapping("/{id}")
    public HistoriaOxigeno findById(@PathVariable int id) {
        return this.serviceCrud.findById(id);
    }

    /**
     * Metodo HTTP GET que retorna una lista con los últimos cinco niveles de
     * oxígeno registrados.
     * 
     * @return una lista de objetos HistoriaOxigeno con los últimos cinco niveles de
     *         oxigeno registrados.
     */
    @GetMapping("/five")
    public List<HistoriaOxigeno> findLastFive() {
        return this.serviceCrud.findLasFive();
    }
}
