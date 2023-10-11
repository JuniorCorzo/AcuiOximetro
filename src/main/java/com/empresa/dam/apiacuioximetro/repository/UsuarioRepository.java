package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.Usuario;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ListCrudRepository<Usuario, Integer> {
    Usuario findByCorreoAndClave(String correo, String clave);
}
