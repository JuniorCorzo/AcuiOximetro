package com.empresa.dam.apiacuioximetro.repository;

import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import com.empresa.dam.apiacuioximetro.utils.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SuppressWarnings("ALL")
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UsuarioRepositoryTests {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void UsuarioRepository_SaveAll_ReturnSavedUsuario() {
        Usuarios usuario = getUsuario();
        usuarioRepository.save(usuario);

        Usuarios usuarioSave = usuarioRepository.findById(usuario.getIdUsuario()).orElse(null);

        Assertions.assertNotNull(usuarioSave);
        Assertions.assertEquals(usuario.getIdUsuario(), usuarioSave.getIdUsuario());
    }

    @Test
    public void UsuarioRepository_GetById_ReturnUsuarioById(){
        Usuarios usuario = getUsuario();
        usuarioRepository.save(usuario);

        Usuarios usuarioGetById = usuarioRepository.findById(usuario.getIdUsuario()).get();

        Assertions.assertNotNull(usuarioGetById);
        Assertions.assertEquals(usuario.getIdUsuario(), usuarioGetById.getIdUsuario());
    }

    @Test
    public void UsuarioRepository_UpdateUsuario_ReturnUsuarioUpdated(){
        Usuarios usuario = getUsuario();
        usuarioRepository.save(usuario);

        usuarioRepository.save(Usuarios.builder()
                .idUsuario(usuario.getIdUsuario())
                .rol(Role.USUARIO)
                .nombre("Yesica")
                .apellido("Vargas")
                .correo("yesica@gmail.com")
                .clave("1234")
                .build());
        Usuarios usuarioUpdate = usuarioRepository.findById(usuario.getIdUsuario()).get();

        Assertions.assertNotNull(usuarioUpdate);
        Assertions.assertEquals(usuario.getIdUsuario(), usuarioUpdate.getIdUsuario());
        Assertions.assertNotEquals(usuario.getRol(), usuarioUpdate.getRol());
        Assertions.assertNotEquals(usuario.getNombre(), usuarioUpdate.getNombre());
        Assertions.assertNotEquals(usuario.getApellido(), usuarioUpdate.getApellido());
        Assertions.assertNotEquals(usuario.getCorreo(), usuarioUpdate.getCorreo());
        Assertions.assertNotEquals(usuario.getClave(), usuarioUpdate.getClave());
    }

    @Test
    public void UsuarioRepository_GetUsuarioByNombre(){
        Usuarios usuario = getUsuario();
        usuarioRepository.save(usuario);

        System.out.println(usuario.getNombre());
        System.out.println(usuarioRepository.findByNombre(usuario.getNombre()).get());

        /*Assertions.assertNotNull(getUsuarioByNombre);
        Assertions.assertEquals(usuario.getIdUsuario(), getUsuarioByNombre.getIdUsuario());*/
    }

    private static Usuarios getUsuario() {
        return Usuarios.builder()
                .idUsuario(1234567891)
                .rol(Role.ADMINISTRADOR)
                .nombre("Angel")
                .apellido("Corzo")
                .correo("email@gmail.com")
                .clave("0000")
                .build();
    }
}
