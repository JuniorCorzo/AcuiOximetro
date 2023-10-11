package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Usuario;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UsuarioServiceCrud {
    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceCrud(UsuarioRepository repository) {
        this.repository = repository;
    }
    
    public Usuario findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Boolean validate(String correo, String clave){
        return this.repository.findByCorreoAndClave(correo, clave) != null;
    }
    
    public void create(Usuario entity) {
        repository.save(entity);
    }

    
    public void update(Usuario entity) {
        if(!repository.existsById(entity.idUsuario())) throw new RuntimeException("Usuario no existe");
        repository.save(entity);
    }
    
}
