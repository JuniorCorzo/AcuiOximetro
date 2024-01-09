package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.HistoriaOxigeno;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFound;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.repository.HistoriaNivelRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HistoriaServiceCrudTest {
    @Mock
    private HistoriaNivelRepository historiaRepository;
    @InjectMocks
    private HistoriaServiceCrud historiaService;

    @Test
    void HistoriaService_GetByIdEstanques_ReturnListHistoriaOxigeno() throws DataNotFoundById {
        List<HistoriaOxigeno> mockHistoriaList = new ArrayList<>();
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));

        when(historiaRepository.findAllByIdEstanque(Mockito.anyInt())).thenReturn(mockHistoriaList);
        List<HistoriaOxigeno> historiaList = historiaService.getByIdEstanques(1);

        Assertions.assertNotNull(historiaList);
    }

    @Test
    void HistoriaService_GetByIdEstanques_ThrowDataNotFoundById() {
        Assertions.assertThrows(DataNotFoundById.class, () -> historiaService.getByIdEstanques(1));
    }

    @Test
    void HistoriaService_GetLastFiveHistoriaOxigeno_ReturnFiveLastHistoriaOxigeno() throws DataNotFound {
        List<HistoriaOxigeno> mockHistoriaList = new ArrayList<>();
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));
        mockHistoriaList.add(Mockito.mock(HistoriaOxigeno.class));

        when(historiaRepository.findLastFive()).thenReturn(mockHistoriaList);
        List<HistoriaOxigeno> getLastFiveHistoria = historiaService.getLastFive();

        Assertions.assertNotNull(getLastFiveHistoria);

    }

    @Test
    void HistoriaService_GetLastFiveHistoriaOxigeno_ThrowDataNotFound(){
        Assertions.assertThrows(DataNotFound.class, () -> historiaService.getLastFive());
    }
}