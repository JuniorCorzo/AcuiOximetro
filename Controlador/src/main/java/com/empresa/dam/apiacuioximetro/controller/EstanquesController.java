package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Estanques;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.service.EstanquesServiceCrud;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * EstanquesController es el controlador encargado de gestionar las operaciones
 * CRUD
 */

@RestController
@RequestMapping("api/v1/estanques")
public class EstanquesController {
    private final EstanquesServiceCrud serviceCrud;

    /**
     * Constructor de la clase EstanquesController.
     * 
     * @param serviceCrud servicio para la gestión de los estanques.
     */
    public EstanquesController(EstanquesServiceCrud serviceCrud) {
        this.serviceCrud = serviceCrud;
    }

    /**
     * Metodo HTTP GET que devuelve una lista que contenga todos los datos
     * almacenados en la base de datos
     * 
     * @return List<Estanques>
     */
    @GetMapping
    public List<Estanques> findAll() {
        return this.serviceCrud.findAll();
    }

    /**
     * Metodo HTTO POST que realiza una consulta a la base de datos para insertar un
     * nuevo estanque
     * 
     * @param estanques - Objecto que almacena los datos necesarios de la entidad
     *                  estanques
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void create(@Valid @RequestBody Estanques estanques) {
        this.serviceCrud.create(estanques);
    }

    /**
     * Metodo HTTP PUT que realiza una consulta a la base de datos para actualizar
     * los datos de un estanque
     * 
     * @param estanques - Objecto que almacena los datos necesarios de la entidad
     *                  estanques
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update")
    public void update(@Valid @RequestBody Estanques estanques) throws DataNotFoundById {
        this.serviceCrud.update(estanques);
    }

}
