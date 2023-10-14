package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.Usuario;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UsuarioRepository es el repositorio encargado de gestionar las operaciones
 * CRUD de la entidad usuario
 */
@Repository
public interface UsuarioRepository extends ListCrudRepository<Usuario, Integer> {
    Usuario findByCorreoAndClave(String correo, String clave);
}
