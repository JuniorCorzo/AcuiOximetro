package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Usuario;
import com.empresa.dam.apiacuioximetro.service.UsuarioServiceCrud;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioServiceCrud serviceCrud;

    @Autowired
    public UsuarioController(UsuarioServiceCrud serviceCrud) {
        this.serviceCrud = serviceCrud;
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable int id){
        return this.serviceCrud.findById(id);
    }

    @GetMapping("/validate")
    public Boolean validatedUsuario(@RequestParam("correo") String correo, @RequestParam("clave") String clave){
        return this.serviceCrud.validate(correo, clave);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void create(@Valid @RequestBody Usuario usuario){
        this.serviceCrud.create(usuario);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update")
    public void update(@Valid @RequestBody Usuario usuario){
        this.serviceCrud.update(usuario);
    }
}
