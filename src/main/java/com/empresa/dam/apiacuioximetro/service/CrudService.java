package com.empresa.dam.apiacuioximetro.service;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface CrudService<T> {
    List<T> findAll();
    T findById(int id);
    T create(T entity);
    T update(T entity);
    boolean deleteById(int id);
}
