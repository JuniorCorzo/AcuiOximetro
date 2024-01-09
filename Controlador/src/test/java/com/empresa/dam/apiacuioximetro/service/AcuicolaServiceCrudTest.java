package com.empresa.dam.apiacuioximetro.service;

import com.empresa.dam.apiacuioximetro.entity.Acuicolas;
import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.repository.AcuicolaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AcuicolaServiceCrudTest {
    @Mock
    private AcuicolaRepository acuicolaRepository;
    @InjectMocks
    private AcuicolaServiceCrud acuicolaService;

    @Test
    void AcuicolaService_GetAcuicolaById_ReturnAcuicolaById() throws DataNotFoundById {
        Acuicolas acuicola = Mockito.mock(Acuicolas.class);

        when(acuicolaRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(acuicola));
        Acuicolas acuicolaById = acuicolaService.getById(1);

        Assertions.assertNotNull(acuicolaById);
    }

    @Test
    void AcuicolaService_GetAcuicolaById_ThrowDataNotFoundById(){
        Assertions.assertThrows(DataNotFoundById.class, () -> acuicolaService.getById(1));
    }

}