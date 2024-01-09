package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.Acuicolas;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import com.empresa.dam.apiacuioximetro.service.AcuicolaServiceCrud;
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

@WebMvcTest(AcuicolaController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
@MockBeans({
        @MockBean(UsuarioRepository.class),
        @MockBean(JwtService.class)
})
class AcuicolaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AcuicolaServiceCrud acuicolaService;
    private Acuicolas acuicola;

    @BeforeEach
    void setUp() {
        acuicola = Acuicolas.builder()
                .idAcuicola(1)
                .idUsuario(1234567890)
                .idEstanque(1)
                .nombre("Acuicola")
                .direccion("La ye")
                .build();
    }

    @Test
    void AcuicolaController_GetAcuicolaById_ReturnAcuicolaById() throws Exception {
        when(acuicolaService.getById(Mockito.anyInt())).thenReturn(acuicola);
        mockMvc.perform(get("/api/v1/acuicolas/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idAcuicola").value(1));
    }
}