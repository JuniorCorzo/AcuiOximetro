package com.empresa.dam.apiacuioximetro.controller;


import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("")
public class ApiController<T> {
    private CrudService<T> serviceCrud;

    @Autowired
    public ApiController(CrudService<T> serviceCrud) {
        this.serviceCrud = serviceCrud;
    }

    @GetMapping("/")
    public List<T> findAll(){
        return this.serviceCrud.findAll();
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable int id){
        return this.serviceCrud.findById(id);
    }

    @PostMapping("/create")
    public T create(@RequestBody T entity){
        return this.serviceCrud.create(entity);
    }

    @PutMapping("/update")
    public T update(@RequestBody T entity){
        return this.serviceCrud.update(entity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable int id){
        return this.serviceCrud.deleteById(id);
    }
}
