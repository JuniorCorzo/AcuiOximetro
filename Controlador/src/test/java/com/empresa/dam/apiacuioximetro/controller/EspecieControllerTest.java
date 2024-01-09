package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Especies;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import com.empresa.dam.apiacuioximetro.service.EspecieServiceCrud;
import com.empresa.dam.apiacuioximetro.service.JwtService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EspecieController.class)
@AutoConfigureMockMvc(addFilters = false)
@MockBeans({
        @MockBean(UsuarioRepository.class),
        @MockBean(JwtService.class)
})
@ExtendWith(MockitoExtension.class)
class EspecieControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EspecieServiceCrud especieService;

    private Especies especie;

    @BeforeEach
    void setUp() {
        especie = Especies.builder()
                .id(1)
                .nombre("Cachama")
                .build();
    }

    @Test
    void EspecieController_GetEspecieById_ReturnsEspecieById() throws Exception {
        when(especieService.getById(Mockito.anyInt())).thenReturn(especie);
        mockMvc.perform(get("/api/v1/especies/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value(especie.getNombre()));
    }
}