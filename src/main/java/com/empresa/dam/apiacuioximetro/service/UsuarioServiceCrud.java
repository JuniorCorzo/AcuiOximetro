package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Usuario;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class UsuarioServiceCrud {
    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceCrud(UsuarioRepository repository) {
        this.repository = repository;
    }

    
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    
    public Usuario findById(int id) {
        return repository.findById(id).orElse(null);
    }

    
    public Usuario create(Usuario entity) {
        return repository.save(entity);
    }

    
    public Usuario update(Usuario entity) {
        if(!repository.existsById(entity.idUsuario())) throw new RuntimeException("Usuario no existe");
        return repository.save(entity);
    }

    
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
