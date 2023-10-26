package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Usuario;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase es responsable de proporcionar servicios CRUD para la entidad
 * Usuario.
 */
@Service
@NoArgsConstructor
public class UsuarioServiceCrud {
    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceCrud(UsuarioRepository repository) {
        this.repository = repository;
    }

    /**
     * Busca un usuario por su ID.
     * 
     * @param id El ID del usuario a buscar.
     * @return El usuario con el ID especificado, o null si no se encuentra.
     */
    public Usuario findById(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Valida las credenciales de un usuario.
     * 
     * @param correo El correo electrónico del usuario.
     * @param clave  La contraseña del usuario.
     * @return true si las credenciales son válidas, false en caso contrario.
     */
    public Boolean validate(String correo, String clave) {
        return this.repository.findByCorreoAndClave(correo, clave) != null;
    }

    /**
     * Crea un nuevo usuario.
     * 
     * @param entity El usuario a crear.
     */
    public void create(Usuario entity) {
        this.repository.save(entity);
    }

    /**
     * Actualiza un usuario existente.
     * 
     * @param entity El usuario a actualizar.
     * @throws RuntimeException si el usuario no existe.
     */
    public void update(Usuario entity) {
        if (!repository.existsById(entity.idUsuario()))
            throw new RuntimeException("Usuario no existe");
        repository.save(entity);
    }

}
