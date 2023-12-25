package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * UsuarioRepository es el repositorio encargado de gestionar las operaciones
 * CRUD de la entidad usuario
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
    Usuarios findByCorreoAndClave(String correo, String clave);

    Optional<Usuarios> findByNombre(@NotNull @NotEmpty String nombre);
}
