package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import com.empresa.dam.apiacuioximetro.exceptions.usuario.UserExist;
import com.empresa.dam.apiacuioximetro.exceptions.usuario.UserNotExist;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import com.empresa.dam.apiacuioximetro.utils.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceCrudTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioServiceCrud service;

    @Test
    void UsuarioService_CreateUsuario_UsuarioCreate() throws UserExist {
        Usuarios usuario = Usuarios.builder()
                .idUsuario(1234567890)
                .rol(Role.ADMINISTRADOR)
                .nombre("Angel")
                .apellido("Corzo")
                .correo("prueba@gmail.com")
                .password("1234")
                .build();

        when(repository.save(Mockito.any(Usuarios.class))).thenReturn(usuario);
        Usuarios saveUsuario = service.create(usuario);

        Assertions.assertNotNull(saveUsuario);
    }

    @Test
    void UsuarioService_CreateUsuario_ThrowUserExist() {
        Usuarios usuario = Usuarios.builder()
                .idUsuario(1234567890)
                .rol(Role.ADMINISTRADOR)
                .nombre("Angel")
                .apellido("Corzo")
                .correo("prueba@gmail.com")
                .password("1234")
                .build();

        try {
            when(service.create(usuario))
                    .thenThrow(new UserExist(1234567890));
        } catch (UserExist ignored){}

        Assertions.assertThrows(UserExist.class, () -> service.create(usuario));
    }

    @Test
    void UsuarioService_UpdateUsuario_ReturnUsuarioUpdated(){
        Usuarios usuario = Usuarios.builder()
                .idUsuario(1234567890)
                .rol(Role.ADMINISTRADOR)
                .nombre("Angel")
                .apellido("Corzo")
                .correo("prueba@gmail.com")
                .password("1234")
                .build();

        when(repository.existsById(usuario.getIdUsuario())).thenReturn(true);
        when(repository.save(usuario)).thenReturn(usuario);
        Usuarios updateUsuario = service.update(usuario);

        Assertions.assertNotNull(updateUsuario);
    }

    @Test
    void UsuarioService_UpdateUsuario_ThrowUserNotExist() {
        Usuarios usuario = Mockito.mock(Usuarios.class);

        try {
            when(service.update(usuario))
                    .thenThrow(new UserNotExist(1234567890));
        } catch (UserNotExist ignored) {
        }

        Assertions.assertThrows(UserNotExist.class, () -> service.update(usuario));
    }

    @Test
    void UsuarioService_GetUsuarioById_ReturnUsuarioById() throws UserNotExist {
        Usuarios usuario = Mockito.mock(Usuarios.class);

        when(repository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(usuario));
        Usuarios usuarioById = service.getById(1234567890);

        Assertions.assertNotNull(usuarioById);
    }

    @Test
    void UsuarioService_GetUsuarioById_ThrowUserNotExist() throws UserNotExist {
        Usuarios usuario = Mockito.mock(Usuarios.class);

        try {
            when(service.getById(Mockito.anyInt())).thenThrow(new UserNotExist(1234567890));
        } catch (UserNotExist ignored){}

        Assertions.assertThrows(UserNotExist.class, () -> service.getById(1234567890));
    }
}