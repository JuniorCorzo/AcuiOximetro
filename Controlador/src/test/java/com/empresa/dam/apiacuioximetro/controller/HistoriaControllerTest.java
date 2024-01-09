package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import com.empresa.dam.apiacuioximetro.service.HistoriaServiceCrud;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HistoriaController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class HistoriaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HistoriaServiceCrud historiaService;
    @MockBean
    private UsuarioRepository usuarioRepository;
    @MockBean
    private JwtService jwtService;
    private List<HistoriaOxigeno> mockHistoriaList;
    @BeforeEach
    void setUp() {
        mockHistoriaList = new ArrayList<>();
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));
    }

    @Test
    void HistoriaController_GetHistoriaOxigenoByIdEstanque_ReturnHistoriaOxigenoByIdEstanque() throws Exception {
        when(historiaService.getByIdEstanques(Mockito.anyInt())).thenReturn(mockHistoriaList);
        mockMvc.perform(get("/api/v1/historia/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void HistoriaController_GetFiveLastHistoria_ReturnFiveLastHistoria() throws Exception {
        when(historiaService.getLastFive()).thenReturn(mockHistoriaList);
        mockMvc.perform(get("/api/v1/historia/five")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}