package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import com.empresa.dam.apiacuioximetro.utils.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UsuarioRepositoryTests {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void UsuarioRepository_SaveAll_ReturnSavedUsuario() {
        Usuarios usuario = Usuarios.builder()
                .idUsuario(1234567891)
                .rol(Role.ADMINISTRADOR)
                .nombre("Angel")
                .apellido("Corzo")
                .correo("email.gmail.com")
                .clave("0000")
                .build();

        usuarioRepository.save(usuario);
        Usuarios usuarioSave = usuarioRepository.findById(usuario.getIdUsuario()).orElse(null);

        Assertions.assertNotNull(usuarioSave);
        Assertions.assertEquals(usuario.getIdUsuario(), usuarioSave.getIdUsuario());
    }
}
