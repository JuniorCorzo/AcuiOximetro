package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Usuarios;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import com.empresa.dam.apiacuioximetro.service.JwtService;
import com.empresa.dam.apiacuioximetro.service.UsuarioServiceCrud;
import com.empresa.dam.apiacuioximetro.utils.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
@AutoConfigureMockMvc(addFilters = false)
@MockBeans({
        @MockBean(UsuarioRepository.class),
        @MockBean(JwtService.class)
})
@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UsuarioServiceCrud usuarioService;

    private Usuarios usuario;

    @BeforeEach
    void setUp() {
        usuario = Usuarios.builder()
                .idUsuario(1234567890)
                .nombre("Angel")
                .apellido("Corzo")
                .rol(Role.ADMINISTRADOR)
                .correo("prueba@gmail.com")
                .password("1234")
                .build();
    }

    @Test
    void UsuarioController_CreateUsuario_UsuarioCreated() throws Exception {
        when(usuarioService.create(usuario)).thenReturn(usuario);
        mockMvc.perform(post("/api/v1/usuarios/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "idUsuario": 1234567890,
                            "rol": "ADMINISTRADOR",
                            "nombre": "Angel",
                            "apellido": "Corzo",
                            "correo": "p@gmail.com",
                            "password": "12345"
                        }
                        """
                )
        ).andExpect(status().isCreated());
    }

    @Test
    void UsuarioController_UpdateUsuario_UsuarioUpdated() throws Exception {
        Usuarios usuarioUpdate = Usuarios.builder()
                .idUsuario(1234567890)
                .nombre("Angelica")
                .apellido("Corzo")
                .rol(Role.USUARIO)
                .correo("prueba@gmail.com")
                .password("1234")
                .build();
        when(usuarioService.update(usuario)).thenReturn(usuarioUpdate);
        mockMvc.perform(put("/api/v1/usuarios/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "idUsuario": 1234567890,
                                    "rol": "ADMINISTRADOR",
                                    "nombre": "Angelica",
                                    "apellido": "Corzo",
                                    "correo": "prueba@gmail.com",
                                    "password": "12345"
                                }
                                """
                        ))
                .andExpect(status().isCreated());
    }

    @Test
    void UsuarioController_GetUsuarioById_ReturnUsuarioById() throws Exception {
        when(usuarioService.getById(Mockito.anyInt())).thenReturn(usuario);
        mockMvc.perform(get("/api/v1/usuarios/1234567890")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idUsuario").value(usuario.getIdUsuario()));
    }
}