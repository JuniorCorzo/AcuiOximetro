package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@DataJdbcTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UsuarioRepositoryTests {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void UsuarioRepository_SaveAll_ReturnSavedUsuario() {
        Usuarios usuario = Usuarios.builder()
                .idUsuario(1234567891)
                .rol("Administrador")
                .nombre("Angel")
                .apellido("Corzo")
                .correo("email.gmail.com")
                .clave("0000")
                .build();

//        Usuarios usuarioSaved = usuarioRepository.create(usuario.idUsuario(),
//                usuario.rol(), usuario.nombre(),usuario.apellido(),
//                usuario.correo(), usuario.clave());


        /*Assertions.assertNotNull(usuarioSaved);
        Assertions.assertEquals(1234567891, usuarioSaved.idUsuario());*/
    }
}
