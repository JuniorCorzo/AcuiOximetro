package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Estanques;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import com.empresa.dam.apiacuioximetro.service.EstanquesServiceCrud;
import com.empresa.dam.apiacuioximetro.service.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EstanquesController.class)
@AutoConfigureMockMvc(addFilters = false)
@MockBeans({
        @MockBean(UsuarioRepository.class),
        @MockBean(JwtService.class)
})
@ExtendWith(MockitoExtension.class)
public class EstanqueControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EstanquesServiceCrud estanqueService;
    @Autowired
    private ObjectMapper objectMapper;

    private Estanques estanque;

    @BeforeEach
    void setUp() {
        estanque = Estanques.builder()
                .id(1)
                .idEspecie(1)
                .tipoEstanque("Geomenbrana")
                .cantidadPeces(1000)
                .build();
    }

    @Test
    void EstanqueController_CreateEstanque_ReturnsStatusCreated() throws Exception {
        when(estanqueService.create(estanque)).thenReturn(estanque);
        mockMvc.perform(post("/api/v1/estanques/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estanque)))
                .andExpect(status().isCreated());
    }

    @Test
    void EstanqueController_UpdateEstanque_ReturnsStatusCreated() throws Exception {
        when(estanqueService.update(estanque)).thenReturn(estanque);
        mockMvc.perform(put("/api/v1/estanques/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estanque)))
                .andExpect(status().isCreated());
    }

    @Test
    void EstanquesController_GetAllEstanque_ReturnsAllEstanques() throws Exception {
        when(estanqueService.getAll()).thenReturn(List.of(estanque));
        mockMvc.perform((get("/api/v1/estanques"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
