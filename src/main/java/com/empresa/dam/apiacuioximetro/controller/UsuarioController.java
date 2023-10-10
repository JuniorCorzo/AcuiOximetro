package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController extends ApiController<Usuario>{
    public UsuarioController(CrudService<Usuario> serviceCrud){
        super(serviceCrud);
    }
}
