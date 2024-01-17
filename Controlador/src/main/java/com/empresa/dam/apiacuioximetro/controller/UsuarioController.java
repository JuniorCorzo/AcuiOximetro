package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import com.empresa.dam.apiacuioximetro.exceptions.usuario.CredentialsNotValid;
import com.empresa.dam.apiacuioximetro.exceptions.usuario.UserExist;
import com.empresa.dam.apiacuioximetro.exceptions.usuario.UserNotExist;
import com.empresa.dam.apiacuioximetro.service.UsuarioServiceCrud;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Esta clase es el controlador para la entidad Usuario. Contiene los métodos
 * para manejar las solicitudes HTTP relacionadas con los usuarios.
 */
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioServiceCrud serviceCrud;

    /**
     * Constructor de la clase UsuarioController.
     *
     * @param serviceCrud Objeto de la clase UsuarioServiceCrud que se utiliza para
     *                    realizar operaciones CRUD en la base de datos.
     */
    @Autowired
    public UsuarioController(UsuarioServiceCrud serviceCrud) {
        this.serviceCrud = serviceCrud;
    }

    /**
     * Método HTTP GET que devuelve un objeto Usuario según el ID proporcionado.
     *
     * @param id ID del usuario que se desea buscar.
     * @return Objeto Usuario correspondiente al ID proporcionado.
     */
    @GetMapping("/{id}")
    public Usuarios getById(@PathVariable int id) throws UserNotExist {
        return this.serviceCrud.getById(id);
    }

    /**
     * Método HTTP POST que crea un nuevo usuario en la base de datos.
     *
     * @param usuario Objeto Usuario que se desea crear.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void create(@Valid @RequestBody Usuarios usuario) throws UserExist {
        this.serviceCrud.create(usuario);
    }

    /**
     * Método HTTP PUT que actualiza un usuario existente en la base de datos.
     *
     * @param usuario Objeto Usuario que se desea actualizar.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public void update(@Valid @RequestBody Usuarios usuario) throws UserNotExist {
        this.serviceCrud.update(usuario);
    }

}
