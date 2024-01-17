package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import com.empresa.dam.apiacuioximetro.exceptions.usuario.UserExist;
import com.empresa.dam.apiacuioximetro.exceptions.usuario.UserNotExist;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public Usuarios getById(int id) throws UserNotExist {
        return repository.findById(id).orElseThrow(() -> new UserNotExist(id));
    }

    /**
     * Crea un nuevo usuario.
     *
     * @param users El usuario a crear.
     * @return
     */
    public Usuarios create(Usuarios users) throws UserExist {
        if (this.repository.existsById(users.getIdUsuario())) throw new UserExist(users.getIdUsuario());
        users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));
        return this.repository.save(users);
    }

    /**
     * Actualiza un usuario existente.
     *
     * @param users El usuario a actualizar.
     * @return
     * @throws RuntimeException si el usuario no existe.
     */
    public Usuarios update(Usuarios users) throws UserNotExist {
        if (!repository.existsById(users.getIdUsuario())) throw new UserNotExist(users.getIdUsuario());
        return this.repository.save(users);
    }
}
