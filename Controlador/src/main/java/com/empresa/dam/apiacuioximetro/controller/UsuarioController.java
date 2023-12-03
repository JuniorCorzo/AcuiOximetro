package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Usuario;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.exceptions.UserNotExist;
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
    public Usuario findById(@PathVariable int id) throws UserNotExist {
        return this.serviceCrud.findById(id);
    }

    /**
     * Método HTTP GET que valida las credenciales de un usuario.
     * 
     * @param correo Correo electrónico del usuario.
     * @param clave  Clave del usuario.
     * @return Booleano que indica si las credenciales son válidas o no.
     */
    @GetMapping("/validate")
    public Boolean validatedUsuario(@RequestParam("correo") String correo, @RequestParam("clave") String clave) throws UserNotExist {
        return this.serviceCrud.validate(correo, clave);
    }

    /**
     * Método HTTP POST que crea un nuevo usuario en la base de datos.
     * 
     * @param usuario Objeto Usuario que se desea crear.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void create(@Valid @RequestBody Usuario usuario) {
        this.serviceCrud.create(usuario);
    }

    /**
     * Método HTTP PUT que actualiza un usuario existente en la base de datos.
     * 
     * @param usuario Objeto Usuario que se desea actualizar.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public void update(@Valid @RequestBody Usuario usuario) throws UserNotExist {
        this.serviceCrud.update(usuario);
    }

}
