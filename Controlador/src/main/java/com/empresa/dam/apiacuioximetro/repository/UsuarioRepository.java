package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * UsuarioRepository es el repositorio encargado de gestionar las operaciones
 * CRUD de la entidad usuario
 */
@Repository
public interface UsuarioRepository extends ListCrudRepository<Usuarios, Integer> {
    Usuarios findByCorreoAndClave(String correo, String clave);

    @Modifying
    @Query("INSERT INTO usuarios (usuarios.`id_usuario`, usuarios.`rol`," +
            " usuarios.`nombre`, usuarios.`apellido`, usuarios.`correo`," +
            " usuarios.`clave`) VALUES (:id_usuario, :rol, :nombre, :apellido, :correo, :clave)")
    @Transactional
    Usuarios create(@Param("id_usuario") int id_usuario, @Param("rol") String rol,
                @Param("nombre") String nombre, @Param("apellido") String apellido,
                @Param("correo") String correo, @Param("clave") String clave);
}
