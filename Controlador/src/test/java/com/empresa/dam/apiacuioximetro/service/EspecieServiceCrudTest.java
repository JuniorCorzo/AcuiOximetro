package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.dto.EspecieDTO;
import com.empresa.dam.apiacuioximetro.entity.Especies;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.repository.EspecieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EspecieServiceCrudTest {
    @Mock
    private EspecieRepository especieRepository;
    @InjectMocks
    private EspecieServiceCrud especieService;

    @Test
    void EspecieService_GetEspecieById_ReturnEspecieById() throws DataNotFoundById {
        Especies especie = Mockito.mock(Especies.class);

        when(especieRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(especie));
        Especies especieById = especieService.getById(1);

        Assertions.assertNotNull(especieById);
    }

    @Test
    void EspecieService_GetEspecieById_ThrowDataNotFoundById(){
        Assertions.assertThrows(DataNotFoundById.class, () -> especieService.getById(1));
    }

    @Test
    void EspecieServicie_GetAllNombreEspecies_ReturnNombreEspecies(){
        when(especieRepository.findAllNombre()).thenReturn(List.of(Mockito.mock(EspecieDTO.class)));
        List<EspecieDTO> getAllNombres = this.especieService.getAllNombres();

        Assertions.assertNotNull(getAllNombres);
    }

}