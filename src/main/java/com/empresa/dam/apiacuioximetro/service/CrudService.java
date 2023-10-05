package com.empresa.dam.apiacuioximetro.service;

import java.util.List;

public interface CrudService<T> {
    List<T> findAll();
    T findById(int id);
    T create(T entity);
    T update(T entity);
    boolean deleteById(int id);
}
