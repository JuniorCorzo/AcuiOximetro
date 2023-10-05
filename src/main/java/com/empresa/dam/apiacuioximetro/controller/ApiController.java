package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Usuario;
import com.empresa.dam.apiacuioximetro.service.decorator.ServiceCrudImplDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ApiController {

    final
    ServiceCrudImplDecorator<Usuario> usuariosService;

    @Autowired
    public ApiController(ServiceCrudImplDecorator<Usuario> usuariosService) {
        this.usuariosService = usuariosService;
    }
    @GetMapping("/")
    public List<Usuario> findAll(){
        return usuariosService.findAll();
    }
}
